package by.andersen.intensive.yellow.team.controller.command.impl.report;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;

public class AddReportCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		boolean isReportAdded = false;
		
		String reportTitle = httpServletRequest.getParameter(REPORT_TITLE_PARAMETER.getParameterName());
		String reportBody = httpServletRequest.getParameter(REPORT_BODY_PARAMETER.getParameterName());
		String laborCostsStr = httpServletRequest.getParameter(TIME_COSTS_PARAMETER.getParameterName());
		int laborCosts = Integer.valueOf(laborCostsStr);
		String currentUserName = httpServletRequest.getParameter(USERNAME_PARAMETER.getParameterName());
		
		IReportService reportService = new ReportService();
		try {
			isReportAdded = reportService.addUserReport(currentUserName, reportTitle, reportBody, laborCosts);
			if(isReportAdded) {
				resultPage = new Page(REPORTS_PAGE.getPagePath(), false, REPORT_ADDED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isReportAdded) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, REPORT_ADD_FAILED_MESSAGE.getMessage());
			}
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}

}
