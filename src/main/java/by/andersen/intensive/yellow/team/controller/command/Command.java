package by.andersen.intensive.yellow.team.controller.command;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.page.Page;

public interface Command {
	
	Page execute(HttpServletRequest httpServletRequest);
	
}
