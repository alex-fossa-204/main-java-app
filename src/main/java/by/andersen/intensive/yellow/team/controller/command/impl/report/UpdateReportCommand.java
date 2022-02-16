package by.andersen.intensive.yellow.team.controller.command.impl.report;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

public class UpdateReportCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		boolean isUpdateSuccessfull = false;
		String reportTitle = httpServletRequest.getParameter(REPORT_TITLE_PARAMETER.getParameterName());
		String reportBody = httpServletRequest.getParameter(REPORT_BODY_PARAMETER.getParameterName());
		String reportLaborCostStr = httpServletRequest.getParameter(TIME_COSTS_PARAMETER.getParameterName());
		int reportLaborCost = Integer.valueOf(reportLaborCostStr);
		//String oldReportTitle = httpServletRequest.getParameter(OLD_REPORT_TITLE_PARAMETER.getParameterName());
		String reportIdStr = httpServletRequest.getParameter(REPORT_ID_PARAMETER.getParameterName());
		long reportId = Long.valueOf(reportIdStr);
		IReportService reportService = new ReportService();
		try {
			isUpdateSuccessfull = reportService.updateUserReport(reportId, reportTitle, reportBody, reportLaborCost);
			System.out.println(isUpdateSuccessfull);
			if(isUpdateSuccessfull) {
				resultPage = new Page(REPORTS_PAGE.getPagePath(), false, REPORT_UPDATED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isUpdateSuccessfull) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), false, REPORT_UPDATE_FAILED_MESSAGE.getMessage());
			}
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		
		return resultPage;
	}

}
