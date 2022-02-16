package main.java.app.test.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

public class GetJsonMapTest {
	
	@Test
	public void getJsonMapTest() {
		IReportService reportService = new ReportService();
		
		try {
			Map<UserDTO, List<ReportDTO>> map = reportService.getAllUsersReportsDtoMapByDate("2022-02-16");
			String json = parseMapToJson(map);
			System.out.println(json);
		} catch (ServiceException e) {
			System.out.println(e);
		}
	}
	
	private String parseMapToJson(Map<UserDTO, List<ReportDTO>> usersReports) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.disableHtmlEscaping();
		gsonBuilder.enableComplexMapKeySerialization();
		Gson gson = gsonBuilder.create();
		String result = gson.toJson(usersReports);
		return result;
	}
}
