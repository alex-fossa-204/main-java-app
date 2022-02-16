package by.andersen.intensive.yellow.team.controller.command;

import by.andersen.intensive.yellow.team.controller.command.impl.global.EmptyCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.AddReportCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.DeleteReportCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.GetJsonReportsCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowAddReportFormCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowEditReportFormCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowUserReportsCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.UpdateReportCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.AddUserCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.DeleteUserCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.GetAllUsersCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.ShowUserInfoCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.UpdateUserCommand;

public enum CommandsEnum {
	
	ADD_USER(new AddUserCommand()),
	
	GET_ALL_USERS(new GetAllUsersCommand()),
	
	SHOW_USER_INFO(new ShowUserInfoCommand()),
	
	UPDATE_USER(new UpdateUserCommand()),
	
	DELETE_USER(new DeleteUserCommand()),
	
	ADD_REPORT(new AddReportCommand()),
	
	DELETE_REPORT(new DeleteReportCommand()),
	
	GET_JSON_REPORTS(new GetJsonReportsCommand()),
	
	SHOW_ADD_REPORT_FORM(new ShowAddReportFormCommand()),
	
	SHOW_EDIT_REPORT_FORM(new ShowEditReportFormCommand()),
	
	SHOW_USER_REPORTS(new ShowUserReportsCommand()),
	
	UPDATE_REPORT(new UpdateReportCommand()),
	
	EMPTY_COMMAND(new EmptyCommand());
	
	Command command;
	
	CommandsEnum(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return this.command;
	}
	

}
