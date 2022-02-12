package by.andersen.intensive.bakulin.controller.command;

import by.andersen.intensive.bakulin.controller.command.impl.user.AddUserCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.DeleteUserCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.GetAllUsersCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.UpdateUserCommand;

public enum CommandsEnum {
	
	ADD_USER(new AddUserCommand()),
	
	GET_ALL_USERS(new GetAllUsersCommand()),
	
	UPDATE_USER(new UpdateUserCommand()),
	
	DELETE_USER(new DeleteUserCommand());
	
	Command command;
	
	CommandsEnum(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return this.command;
	}
	

}
