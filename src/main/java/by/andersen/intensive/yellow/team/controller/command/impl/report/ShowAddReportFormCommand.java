package by.andersen.intensive.yellow.team.controller.command.impl.report;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;

import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;

public class ShowAddReportFormCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page page = new Page(REPORT_FORM_PAGE.getPagePath(), false);
		String currentUserName = httpServletRequest.getParameter("");
		return page;
	}

}
