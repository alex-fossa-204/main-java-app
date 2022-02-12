package by.andersen.intensive.bakulin.controller.command;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.page.Page;

public interface Command {
	
	Page execute(HttpServletRequest httpServletRequest);
	
}
