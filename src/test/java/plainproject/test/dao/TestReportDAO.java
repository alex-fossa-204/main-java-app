package plainproject.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import by.andersen.intensive.yellow.team.dao.IReportDAO;
import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.dao.sql.connection.manager.ConnectionManager;
import by.andersen.intensive.yellow.team.dao.sql.impl.SqlReportDAO;
import by.andersen.intensive.yellow.team.entity.Report;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReportDAO {

	ConnectionManager connectionManager = new ConnectionManager();
	String reportTitle = "Dao testing add report1";

	@Test
	public void testFindAll() {

		try (Connection connection = connectionManager.getConnection()) {
			IReportDAO reportDao = new SqlReportDAO(connection);
			List<Report> reports = null;
			try {
				reports = reportDao.findAll();
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Find All:");
			reports.stream().forEach(e -> System.out.println(e));
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}
	
	@Test
	public void testFindUserReportsAll() {
		String username = "dogeadmin16";
		try (Connection connection = connectionManager.getConnection()) {
			IReportDAO reportDao = new SqlReportDAO(connection);
			List<Report> reports = null;
			try {
				reports = reportDao.findUserReportsAll(username);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Find All Reports of user: " + username);
			reports.stream().forEach(e -> System.out.println(e));
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

	@Test
	public void testFindById() {	
		try (Connection connection = connectionManager.getConnection()) {
			IReportDAO reportDao = new SqlReportDAO(connection);
			Report report = null;
			long id = 0;
			try {
				List<Report> reports = reportDao.findAll();
				id = reports.get(0).getId();
				report = reportDao.getById(id);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println(String.format("Find By id = %d; entity = %s", id, report));
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

	@Test
	public void testFindByTitle() {
		String title = "PostgreSQL Try On";
		try (Connection connection = connectionManager.getConnection()) {
			IReportDAO reportDao = new SqlReportDAO(connection);
			Report report = null;
			try {
				report = reportDao.findReportByTitle(title);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println(String.format("Find By title = %s; entity = %s", title, report));
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

	@Test
	public void testCreate() {
		System.out.println("Save Report:");
		try (Connection connection = connectionManager.getConnection()) {
			IReportDAO reportDao = new SqlReportDAO(connection);
			boolean isSaved = false;
			String reportBody = "created UserDTO, Created Query to Add report";
			long reporterId = 27;
			int laborCost = 1;
			Report report = new Report(reportTitle, reportBody, reporterId, laborCost);
			try {
				isSaved = reportDao.save(report);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			if (isSaved) {
				System.out.println("Saved to DB: " + report);
			}
			if (!isSaved) {
				System.out.println("Not Saved");
			}
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

	@Test
	public void testDelete() {
		boolean isDelete = false;
		Report reportDelete = null;
		System.out.println("Delete Report:");
		try (Connection connection = connectionManager.getConnection()) {
			IReportDAO reportDao = new SqlReportDAO(connection);
			try {
				reportDelete = reportDao.findReportByTitle(reportTitle);
				System.out.println(reportDelete);
				long reportDeleteId = reportDelete.getId();
				System.out.println("Report id to delete: " + reportDeleteId);

				isDelete = reportDao.delete(reportDeleteId);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			if (isDelete) {
				System.out.println("Deleted from DB: " + reportDelete);
			}
			if (!isDelete) {
				System.out.println("Delete  unsuccessfull: " + reportDelete);
			}
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

}
