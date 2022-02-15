package by.andersen.intensive.yellow.team.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.entity.impl.User;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;

public interface IReportService {
	
	boolean addUserReport(User user, String reportTitle, String reportBody, Date reportDate, int laborCost) throws ServiceException;
	
	boolean updateUserReport(String oldReportTitle, String reportTitle, String reportBody, Date reportDate, int laborCost) throws ServiceException;
	
	boolean deleteUserReport(long reportId) throws ServiceException;
	
	Map<User, List<ReportDTO>> getAllUsersReportsMap() throws ServiceException;
}
