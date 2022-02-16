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
	public boolean updateUserReport(long reportId, String reportTitle, String reportBody,
			int laborCost) throws ServiceException {
		boolean result = false;
		Report reportToUpdate = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			reportToUpdate = reportDao.getById(reportId);
			reportToUpdate.setReportTitle(reportTitle);
			reportToUpdate.setReportBody(reportBody);
			reportToUpdate.setLaborCost(laborCost);
			System.out.println("report to update: " + reportToUpdate);
			result = reportDao.update(reportToUpdate);
			System.out.println("Service result = " + result);
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
	public Map<UserDTO, List<ReportDTO>> getAllUsersReportsDtoMapByDate(String date) throws ServiceException {
		Map<UserDTO, List<ReportDTO>> usersReports = new HashMap<UserDTO, List<ReportDTO>>();

		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			IUserDAO userDao = new SqlUserDAO(connectionManager.getConnection());

			List<User> users = userDao.findAll();
			for (User user : users) {
				List<Report> currentUserReports = reportDao.findUserReportsByDate(user.getUserName(), date);
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
	
	

	@Override
	public Report getUserReportById(String username, long reportId) throws ServiceException {
		Report resultReport = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			resultReport = reportDao.findUserReportById(username, reportId);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return resultReport;
	}

	@Override
	public List<Report> getAllReportsForSingleUser(String username) throws ServiceException {
		List<Report> currentUserReports = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			currentUserReports = reportDao.findUserReports(username);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return currentUserReports;
	}
	
	

	@Override
	public List<Report> getAllReportsForSingleUserPageable(String username, int page, int recordsPerPage, int totalPages) throws ServiceException {
		List<Report> singleUserReportsPageable = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IReportDAO reportDao = new SqlReportDAO(connectionManager.getConnection());
			List<Report> allReports = reportDao.findUserReports(username);
			singleUserReportsPageable = paginateReports(page, recordsPerPage, allReports, totalPages);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return singleUserReportsPageable;
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
		return new UserDTO(user.getFirstName(), user.getLastName());
	}
	
	private List<Report> paginateReports(int page, int recordsPerPage, List<Report> allReports, int totalPages) {
		List<Report> result = new ArrayList<>();
		int allRecords = allReports.size();
		int recordCounter = 0;
		if (page < totalPages) {
			if (page == 1) {
				for (int record = 0; record < recordsPerPage; record++) {
					Report report = allReports.get(record);
					result.add(report);
					++recordCounter;
				}
			}
			if (page > 1) {
				recordCounter = recordsPerPage * (page - 1);
				for (int record = recordCounter; record < page * recordsPerPage; record++) {
					Report report = allReports.get(record);
					result.add(report);
					++recordCounter;
				}
			}
		}
		if (page == totalPages) {
			recordCounter = recordsPerPage * (page - 1);
			for (int record = recordCounter; record < allRecords; record++) {
				Report report = allReports.get(record);
				result.add(report);
				++recordCounter;
			}
		}
		return result;
	}

	@Override
	public int getSingleUserReportsQuantity(String username) throws ServiceException {
		int reportsQuantity = 0;
		try {
			List<Report> reports = getAllReportsForSingleUser(username);
			reportsQuantity = reports.size();
		} catch (ServiceException exception) {
			throw exception;
		}
		return reportsQuantity;
	}
	
	

}
