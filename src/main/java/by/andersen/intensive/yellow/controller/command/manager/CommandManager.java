package by.andersen.intensive.yellow.controller.command.manager;

import static by.andersen.intensive.yellow.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.yellow.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.controller.command.constant.MessageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.controller.command.Command;
import by.andersen.intensive.yellow.controller.command.CommandsEnum;
import by.andersen.intensive.yellow.controller.command.impl.global.EmptyCommand;

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
