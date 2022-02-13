package by.andersen.intensive.bakulin.controller.command;

import by.andersen.intensive.bakulin.controller.command.impl.global.EmptyCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.AddUserCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.DeleteUserCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.GetAllUsersCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.ShowUserInfoCommand;
import by.andersen.intensive.bakulin.controller.command.impl.user.UpdateUserCommand;

public enum CommandsEnum {
	
	ADD_USER(new AddUserCommand()),
	
	GET_ALL_USERS(new GetAllUsersCommand()),
	
	SHOW_USER_INFO(new ShowUserInfoCommand()),
	
	UPDATE_USER(new UpdateUserCommand()),
	
	DELETE_USER(new DeleteUserCommand()),
	
	EMPTY_COMMAND(new EmptyCommand());
	
	Command command;
	
	CommandsEnum(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return this.command;
	}
	

}
