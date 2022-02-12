package by.andersen.intensive.bakulin.controller.command.manager;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.command.CommandsEnum;

import by.andersen.intensive.bakulin.controller.command.impl.global.EmptyCommand;

import static by.andersen.intensive.bakulin.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.bakulin.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.bakulin.controller.command.constant.CommandAttribute.*;

public class CommandManager {
	
	public Command defineCommand(HttpServletRequest httpServletRequest) {
		Command command = null;
		
		String action = httpServletRequest.getParameter(COMMAND_PARAM.getParameterName());
		if(action == null || action.isEmpty()) {
			command = new EmptyCommand();
		}
		try {
			CommandsEnum commandEnumValue = CommandsEnum.valueOf(action.toUpperCase());
			command = commandEnumValue.getCommand();
		} catch (IllegalArgumentException illegalArgumentException) {
			String message = String.format("%s %s", COMMAND_ERROR_MESSAGE, action);
			httpServletRequest.setAttribute(MESSAGE_ATTRIBUTE.getAttributeName(), message);
		}
		return command;
	}
}
