package by.andersen.intensive.yellow.team.controller.command.impl.global;

import javax.servlet.http.HttpServletRequest;


import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.controller.page.constant.PageEnum;

public class RunDaemonCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		return new Page(PageEnum.DAEMON_PAGE.getPagePath(), false);
	}

}
