package by.andersen.intensive.yellow.controller.command;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.controller.page.Page;

public interface Command {
	
	Page execute(HttpServletRequest httpServletRequest);
	
}
