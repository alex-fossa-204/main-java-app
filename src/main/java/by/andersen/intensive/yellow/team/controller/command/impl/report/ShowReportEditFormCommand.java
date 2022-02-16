package by.andersen.intensive.yellow.team.controller.command.impl.report;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.entity.impl.Report;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;

public class ShowReportEditFormCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		
		String username = httpServletRequest.getParameter(USERNAME_PARAMETER.getParameterName());
		Long reportId = Long.valueOf(httpServletRequest.getParameter(REPORT_ID_PARAMETER.getParameterName()));
		IReportService reportService = new ReportService();
		
		try {
			Report report = reportService.getUserReportById(username, reportId);
			if(report != null) {
				httpServletRequest.setAttribute(REPORT_ATTRIBUTE.getAttributeName(), report);
				httpServletRequest.setAttribute(USER_NAME_ATTRIBUTE.getAttributeName(), username);
				httpServletRequest.setAttribute(REPORT_ID_ATTRIBUTE.getAttributeName(), report.getId());
				resultPage = new Page(REPORT_FORM_PAGE.getPagePath(), false);
			}
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShowEditReportFormCommand []");
		return builder.toString();
	}
	
	

}
