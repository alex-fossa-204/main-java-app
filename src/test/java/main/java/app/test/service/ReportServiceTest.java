package main.java.app.test.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;
import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportServiceTest {
	
	String username = "harrison.ford34";
	String reportTitle = "Test Report Service";
	String reportBody = "Testing report service functionality with Junit4";
	int laborCost = 2;
	
	
	@Test
	public void testAddUserReport() {
		System.out.println("Service Add Report Test:");
		
		IReportService reportService = new ReportService();
		
		try {
			boolean result = reportService.addUserReport(username, reportTitle, reportBody, laborCost);
			if(result) {
				System.out.println("Report Successfully Added: " + username + " " + reportTitle + " " + reportBody + " " + laborCost);
			}
			if(!result) {
				System.out.println("Report Add Failed");
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\n");
	}
	
	@Test
	public void testDeleteUserReport() {
		System.out.println("Service Delete Report:");
		
		IReportService reportService = new ReportService();
		Report reportToDelete = null;
		boolean isReportReleted = false;
		try {
			System.out.println("\tService Find Report By title: " + reportTitle);
			reportToDelete = reportService.getReportByTitle(reportTitle);
			if(reportToDelete != null) {
				System.out.println("\tSuccessfully find: " + reportToDelete);
			}
			
			isReportReleted = reportService.deleteUserReport(reportToDelete.getId());
			if(isReportReleted) {
				System.out.println("Report deleted successfully: " + reportToDelete);
			}
			if(!isReportReleted) {
				System.out.println("Report delete failed: " + reportToDelete);
			}
			System.out.println("\n");
		} catch(ServiceException serviceException) {
			System.err.println(serviceException);
		}
	}
	
	@Test
	public void testGetAllUsersReports() throws ParseException {
		String stringDate = "2022-02-13";
		IReportService reportService = new ReportService();
		
		try {
			Map<UserDTO, List<ReportDTO>> usersReports = reportService.getAllUsersReportsMapByDate(stringDate);
			for(Map.Entry<UserDTO, List<ReportDTO>> entry : usersReports.entrySet()) {
				System.out.println("Key: " + entry.getKey());
				System.out.println("Value (reports array):");
				for (ReportDTO report : entry.getValue()) {
					System.out.println(" " + report);
				}
				System.out.println("\n");
			}
			System.out.println(parseMapToJson(usersReports));
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}
	

	
	private String parseMapToJson(Map<UserDTO, List<ReportDTO>> usersReports) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.disableHtmlEscaping();
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(usersReports);
		return result;
	}
	
}
