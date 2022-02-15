package by.andersen.intensive.yellow.team.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.yellow.team.dao.IReportDAO;
import by.andersen.intensive.yellow.team.dao.IUserDAO;
import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.dao.sql.connection.manager.ConnectionManager;
import by.andersen.intensive.yellow.team.dao.sql.impl.SqlReportDAO;
import by.andersen.intensive.yellow.team.dao.sql.impl.SqlUserDAO;
import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.entity.impl.User;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;

public class ReportService implements IReportService {

	@Override
	public boolean addUserReport(User user, String reportTitle, String reportBody, Date reportDate, int laborCost)
			throws ServiceException {
		return false;
	}

	@Override
	public boolean updateUserReport(Report report, String reportTitle, String reportBody, Date reportDate,
			int laborCost) throws ServiceException {
		return false;
	}

	@Override
	public boolean deleteUserReport(long reportId) throws ServiceException {
		return false;
	}

	@Override
	public Map<User, List<ReportDTO>> getAllUsersReportsMap() throws ServiceException {
		Map<User, List<ReportDTO>> usersReports = new HashMap<User, List<ReportDTO>>();
		IReportDAO reportDao = null;
		IUserDAO userDao = null;
		
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			reportDao = new SqlReportDAO(connectionManager.getConnection());
			userDao = new SqlUserDAO(connectionManager.getConnection());
			
			List<User> users = userDao.findAll();
			for(User user : users) {
				List<Report> currentUserReports = reportDao.findUserReportsAll(user.getUserName());
				usersReports.put(user, convertUserReportListToDTO(currentUserReports));
			}
			
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return usersReports;
	}
	
	private List<ReportDTO> convertUserReportListToDTO(List<Report> reportList) {
		List<ReportDTO> reportListDto = new ArrayList<ReportDTO>();
		for(Report report : reportList) {
			ReportDTO reportDto = new ReportDTO(report.getReportTitle(), report.getReportBody(), report.getReportDate(), report.getLaborCost());
			reportListDto.add(reportDto);
		}
		return reportListDto;
	}

}
