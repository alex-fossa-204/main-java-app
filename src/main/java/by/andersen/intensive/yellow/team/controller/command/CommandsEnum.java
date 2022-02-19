package by.andersen.intensive.yellow.team.controller.command;

import by.andersen.intensive.yellow.team.controller.command.impl.global.EmptyCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.global.GetJsonReportsCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.global.RunDaemonCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.AddReportCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.DeleteReportCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowReportEditFormCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowTodayUserReportsCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowUserReportsByDateCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.ShowUserReportsCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.report.UpdateReportCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.AddUserCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.DeleteUserCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.GetAllUsersCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.ShowUserEditFormCommand;
import by.andersen.intensive.yellow.team.controller.command.impl.user.UpdateUserCommand;

public enum CommandsEnum {
	
	ADD_USER(new AddUserCommand()),
	
	GET_ALL_USERS(new GetAllUsersCommand()),
	
	SHOW_USER_INFO(new ShowUserEditFormCommand()),
	
	UPDATE_USER(new UpdateUserCommand()),
	
	DELETE_USER(new DeleteUserCommand()),
	
	ADD_REPORT(new AddReportCommand()),
	
	DELETE_REPORT(new DeleteReportCommand()),
	
	GET_JSON_REPORTS(new GetJsonReportsCommand()),
	
	SHOW_EDIT_REPORT_FORM(new ShowReportEditFormCommand()),
	
	SHOW_USER_REPORTS(new ShowUserReportsCommand()),
	
	SHOW_USER_REPORTS_BY_DATE(new ShowUserReportsByDateCommand()),
	
	SHOW_TODAY_USER_REPORTS(new ShowTodayUserReportsCommand()),
	
	UPDATE_REPORT(new UpdateReportCommand()),
	
	RUN_DAEMON(new RunDaemonCommand()),
	
	EMPTY_COMMAND(new EmptyCommand());
	
	Command command;
	
	CommandsEnum(Command command) {
		this.command = command;
	}
	
	public Command getCommand() {
		return this.command;
	}
	

}
