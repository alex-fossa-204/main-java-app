package main.java.app.test;

import java.util.List;

import org.junit.Test;

import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;


public class UserReportsByDateTest {
	
	@Test
	public void getUserReportsByDate() {
		String username = "alexey-bakulin404";
		String date = "2022-02-17";
		IReportService reportService = new ReportService();
		try {
			List<Report> reportsByDate = reportService.getAllReportsForSingleUserByDate(username, date);
			reportsByDate.forEach(e -> System.out.println(e));
		} catch(ServiceException serviceException) {
			System.out.println(serviceException);
		}
	}
	
}
