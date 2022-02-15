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
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;
import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.entity.impl.RoleEnum;
import by.andersen.intensive.yellow.team.entity.impl.User;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;

public class ReportService implements IReportService {

	@Override
	public boolean addUserReport(String username, String reportTitle, String reportBody, int laborCost)
			throws ServiceException {
		boolean result = false;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			IUserDAO userDao = new SqlUserDAO(connectionManager.getConnection());
			
			User reporterUser = userDao.findByUserName(username);
			Report report = new Report(reportTitle, reportBody, reporterUser.getId(), laborCost);
			result = reportDao.save(report);
			
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return result;
	}

	@Override
	public boolean updateUserReport(String oldReportTitle, String reportTitle, String reportBody, Date reportDate,
			int laborCost) throws ServiceException {
		boolean result = false;
		Report reportToUpdate = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			reportToUpdate = reportDao.findReportByTitle(reportTitle);
			reportToUpdate.setReportTitle(reportTitle);
			reportToUpdate.setReportBody(reportBody);
			reportToUpdate.setReportDate(reportDate);
			reportToUpdate.setLaborCost(laborCost);
			reportDao.update(reportToUpdate);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return result;
	}

	@Override
	public boolean deleteUserReport(long reportId) throws ServiceException {
		boolean result = false;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			result = reportDao.delete(reportId);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return result;
	}

	@Override
	public Map<UserDTO, List<ReportDTO>> getAllUsersReportsMapByDate(String date) throws ServiceException {
		Map<UserDTO, List<ReportDTO>> usersReports = new HashMap<UserDTO, List<ReportDTO>>();

		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			IUserDAO userDao = new SqlUserDAO(connectionManager.getConnection());

			List<User> users = userDao.findAll();
			for (User user : users) {
				List<Report> currentUserReports = reportDao.findUserReportsAllByDate(user.getUserName(), date);
				UserDTO currentUserDTO = convertUserToDTO(user);
				usersReports.put(currentUserDTO, convertUserReportListToDTO(currentUserReports));
			}

		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return usersReports;
	}
	
	@Override
	public Report getReportByTitle(String reportTitle) throws ServiceException{
		Report resultReport = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			resultReport = reportDao.findReportByTitle(reportTitle);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return resultReport;
	}

	private List<ReportDTO> convertUserReportListToDTO(List<Report> reportList) {
		List<ReportDTO> reportListDto = new ArrayList<ReportDTO>();
		for (Report report : reportList) {
			ReportDTO reportDto = new ReportDTO(report.getReportTitle(), report.getReportBody(), report.getLaborCost());
			reportListDto.add(reportDto);
		}
		return reportListDto;
	}

	private UserDTO convertUserToDTO(User user) {
		return new UserDTO(user.getFirstName(), user.getSecondName(), user.getLastName());
	}

}
