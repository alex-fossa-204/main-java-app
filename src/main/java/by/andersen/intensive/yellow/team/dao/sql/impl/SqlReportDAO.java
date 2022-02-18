package by.andersen.intensive.yellow.team.dao.sql.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.yellow.team.dao.IReportDAO;
import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;
import by.andersen.intensive.yellow.team.entity.impl.Report;

public class SqlReportDAO extends SqlAbstractDAO<Report> implements IReportDAO {
	
	private static final String ID_COL_LABEL = "id";
	private static final String TITLE_COL_LABEL = "title";
	private static final String BODY_COL_LABEL = "body";
	private static final String DATE_COL_LABEL = "date";
	private static final String REPORTED_BY_USER_ID_COL_LABEL = "reported_by";
	private static final String LABOR_COSTS_COL_LABEL = "labor_costs";
	
	private static final String USER_DTO_FIRSTNAME_COL_LABEL = "user_firstname";
	private static final String USER_DTO_LASTNAME_COL_LABEL = "user_lastname";
	
	private static final String SELECT_ALL_USERS_REPORTS_QUERY = "SELECT users.user_firstname, users.user_secondname, users.user_lastname, reports.id, reports.title, reports.reported_by, reports.date, reports.labor_costs, reports.body FROM users INNER JOIN reports ON users.id = reports.reported_by ORDER BY date ASC";
	private static final String SELECT_USER_REPORTS_QUERY = "SELECT users.user_firstname, users.user_secondname, users.user_lastname, reports.id, reports.title, reports.reported_by, reports.date, reports.labor_costs, reports.body FROM users INNER JOIN reports ON users.id = reports.reported_by WHERE users.username =";
	private static final String SELECT_REPORT_BY_ID_QUERY = "SELECT users.user_firstname, users.user_secondname, users.user_lastname, reports.id, reports.title, reports.reported_by, reports.date, reports.labor_costs, reports.body FROM users INNER JOIN reports ON users.id = reports.reported_by WHERE reports.id = ? ORDER BY date ASC";
	private static final String SELECT_REPORT_BY_TITLE_QUERY = "SELECT users.user_firstname, users.user_secondname, users.user_lastname, reports.id, reports.title, reports.reported_by, reports.date, reports.labor_costs, reports.body FROM users INNER JOIN reports ON users.id = reports.reported_by WHERE reports.title = ?";
	private static final String SELECT_USER_REPORT_BY_ID_QUERY = "SELECT users.user_firstname, users.user_secondname, users.user_lastname, reports.id, reports.title, reports.reported_by, reports.date, reports.labor_costs, reports.body FROM users INNER JOIN reports ON users.id = reports.reported_by WHERE reports.id = ? AND users.username = ?";
	private static final String SAVE_USER_REPORT_QUERY = "INSERT INTO reports (title, body, reported_by, labor_costs) VALUES (?, ?, ?, ?)";
	private static final String DELETE_REPORT_BY_ID_QUERY = "DELETE FROM reports WHERE id=?";
	private static final String UPDATE_REPORT_QUERY = "UPDATE reports SET title=?, body=?, labor_costs=? WHERE id = ?";
	private static final String AND_BY_DATE_SELECTION_QUERY = "AND reports.date =";
	
	public SqlReportDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	public Report findReportByTitle(String title) throws DAOException{
		Report report = null;
		try (PreparedStatement preparedStatement = prepareStatementForSqlQuery(SELECT_REPORT_BY_TITLE_QUERY, title)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				report = buildEntity(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return report;
	}
	
	@Override
	public List<Report> findUserReportsByDate(String username, String date) throws DAOException {
		List<Report> entitiesList = new ArrayList<Report>();
		
		try (Statement statement = connection.createStatement()) {
			String sqlQuery = String.format("%s '%s' %s '%s'", SELECT_USER_REPORTS_QUERY, username, AND_BY_DATE_SELECTION_QUERY, date);
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				Report entity = buildEntity(resultSet);
				entitiesList.add(entity);
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return entitiesList;
	}
	
	@Override
	public Report findUserReportById(String username, long id) throws DAOException {
		Report report = null;
		try (PreparedStatement preparedStatement = prepareStatementForSqlQuery(SELECT_USER_REPORT_BY_ID_QUERY, id, username)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				report = buildEntity(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return report;
	}

	@Override
	public List<Report> findUserReports(String username) throws DAOException {
		List<Report> entitiesList = new ArrayList<Report>();
		
		try (Statement statement = connection.createStatement()) {
			String sqlQuery = String.format("%s '%s'", SELECT_USER_REPORTS_QUERY, username);
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				Report entity = buildEntity(resultSet);
				entitiesList.add(entity);
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return entitiesList;
	}
	
	

	@Override
	public boolean update(Report e) throws DAOException {
		boolean result = false;
		String reportTitle = e.getReportTitle();
		String reportBody = e.getReportBody();
		int laborCosts = e.getLaborCost();
		long reportId = e.getId();
		try (PreparedStatement preparedStatement = prepareStatementForSqlQuery(UPDATE_REPORT_QUERY, reportTitle, reportBody, laborCosts, reportId)) {
			int queryResult = preparedStatement.executeUpdate();
			result = queryResult != 0;
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return result;
	}

	@Override
	public Map<String, String> initializeBaseQueries() {
		Map<String, String> baseQueries = new HashMap<String, String>();
		baseQueries.put(QUERY_KEY_SELECT_ALL, SELECT_ALL_USERS_REPORTS_QUERY);
		baseQueries.put(QUERY_KEY_SELECT_BY_ID, SELECT_REPORT_BY_ID_QUERY);
		baseQueries.put(QUERY_KEY_INSERT_ENTITY, SAVE_USER_REPORT_QUERY);
		baseQueries.put(QUERY_KEY_DELETE_BY_ID, DELETE_REPORT_BY_ID_QUERY);
		baseQueries.put(QUERY_KEY_UPDATE_ENTITY, UPDATE_REPORT_QUERY);
		return baseQueries;
	}

	@Override
	public List<Object> getEntityParameters(Report e) {
		List<Object> entityParameters = new ArrayList<Object>();
		String title = e.getReportTitle();
		entityParameters.add(title);
		
		String body = e.getReportBody();
		entityParameters.add(body);
		
		long reporterId = e.getReporterId();
		entityParameters.add(reporterId);
		
		Integer laborCost = e.getLaborCost();
		entityParameters.add(laborCost);
		
		return entityParameters;
	}

	@Override
	public Report buildEntity(ResultSet resultSet) throws DAOException {
		Report report = new Report();
		try {
			
			Long reportId = resultSet.getLong(ID_COL_LABEL);
			report.setId(reportId);
			
			String title = resultSet.getString(TITLE_COL_LABEL);
			report.setReportTitle(title);
			
			String body = resultSet.getString(BODY_COL_LABEL);
			report.setReportBody(body);
			
			Date date = (Date)resultSet.getDate(DATE_COL_LABEL);
			report.setReportDate(date);
			
			String userDtoFirstName = resultSet.getString(USER_DTO_FIRSTNAME_COL_LABEL);
			String userDtoLastName = resultSet.getString(USER_DTO_LASTNAME_COL_LABEL);
			UserDTO reportedBy = new UserDTO(userDtoFirstName, userDtoLastName);
			report.setReportedBy(reportedBy);
			
			Long reporterId = resultSet.getLong(REPORTED_BY_USER_ID_COL_LABEL);
			report.setReporterId(reporterId);
			
			Integer laborCost = resultSet.getInt(LABOR_COSTS_COL_LABEL);
			report.setLaborCost(laborCost);
			
		} catch(SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return report;
	}


}
