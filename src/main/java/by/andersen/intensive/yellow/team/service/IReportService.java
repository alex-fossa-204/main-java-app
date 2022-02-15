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
	
	boolean updateUserReport(String oldReportTitle, String reportTitle, String reportBody, Date reportDate, int laborCost) throws ServiceException;
	
	boolean deleteUserReport(long reportId) throws ServiceException;
	
	Map<UserDTO, List<ReportDTO>> getAllUsersReportsMapByDate(String date) throws ServiceException;
	
	Report getReportByTitle(String reportTitle) throws ServiceException;
}
