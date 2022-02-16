package by.andersen.intensive.yellow.team.controller.command.impl.global;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.entity.dto.ReportDTO;
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

public class GetJsonReportsCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		LocalDate currentdate = LocalDate.now();
		IReportService reportService = new ReportService();
		try {
			Map<UserDTO, List<ReportDTO>> map = reportService.getAllUsersReportsDtoMapByDate(currentdate.toString());
			System.out.println(map.toString());
			Gson gsonParser = getGsonParser();
			String jsonReport = gsonParser.toJson(map);
			httpServletRequest.setAttribute(JSON_DATA_ATTRIBUTE.getAttributeName(), jsonReport);
			resultPage = new Page(JSON_REPORTS_PAGE.getPagePath(), false);
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), false, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}
	
	private Gson getGsonParser() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.disableHtmlEscaping();
		gsonBuilder.enableComplexMapKeySerialization();
		Gson gson = gsonBuilder.create();
		return gson;
	}

}
