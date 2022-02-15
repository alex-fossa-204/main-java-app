package plainproject.test.service;

import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import by.andersen.intensive.yellow.team.entity.User;
import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportServiceTest {
	
	@Test
	public void testGetAllUsersReports() {
		IReportService reportService = new ReportService();
		try {
			Map<User, List<ReportDTO>> usersReports = reportService.getAllUsersReporstMap();
			for(Map.Entry<User, List<ReportDTO>> entry : usersReports.entrySet()) {
				System.out.println(String.format("Key User: %s;\nValue List<Report>: %s\n", entry.getKey(), entry.getValue()));
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}
}
