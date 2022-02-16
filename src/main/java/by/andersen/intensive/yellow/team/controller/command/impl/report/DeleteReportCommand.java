package by.andersen.intensive.yellow.team.controller.command.impl.report;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.service.IReportService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.ReportService;

public class DeleteReportCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		boolean isDeleteSuccessfull = false;
		
		String reportId = httpServletRequest.getParameter(REPORT_ID_PARAMETER.getParameterName());
		long id = Long.valueOf(reportId);
		
		IReportService reportService = new ReportService();
		try {
			isDeleteSuccessfull = reportService.deleteUserReport(id);
			if(isDeleteSuccessfull) {
				resultPage = new Page(REPORTS_PAGE.getPagePath(), false, REPORT_DELETED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isDeleteSuccessfull) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), false, REPORT_DELETE_FAILED_MESSAGE.getMessage());
			}
			
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), false, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}

}
