package by.andersen.intensive.yellow.team.controller.command.impl.global;

import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;

public class EmptyCommand implements Command{

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		return new Page(INDEX_PAGE_PATH.getPagePath(), false);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmptyCommand []");
		return builder.toString();
	}
	
}
