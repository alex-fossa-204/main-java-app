package by.andersen.intensive.bakulin.controller.command.impl.global;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.page.Page;

import static by.andersen.intensive.bakulin.controller.page.constant.PageEnum.*;

public class EmptyCommand implements Command{

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		return new Page(INDEX_PAGE_PATH.getPagePath(), false);
	}

}
