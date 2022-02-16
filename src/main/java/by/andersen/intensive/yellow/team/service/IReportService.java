package by.andersen.intensive.yellow.team.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;
import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.entity.impl.User;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;

public interface IReportService {
	
	boolean addUserReport(String username, String reportTitle, String reportBody, int laborCost) throws ServiceException;
	
	boolean updateUserReport(long reportId, String reportTitle, String reportBody, int laborCost) throws ServiceException;
	
	boolean deleteUserReport(long reportId) throws ServiceException;
	
	Map<UserDTO, List<ReportDTO>> getAllUsersReportsDtoMapByDate(String date) throws ServiceException;
	
	List<Report> getAllReportsForSingleUser(String username) throws ServiceException;
	
	List<Report> getAllReportsForSingleUserPageable(String username, int page, int recordsPerPage, int totalPages) throws ServiceException;
	
	Report getReportByTitle(String reportTitle) throws ServiceException;
	
	Report getUserReportById(String username, long reportId) throws ServiceException;
	
	int getSingleUserReportsQuantity(String username) throws ServiceException;
}
