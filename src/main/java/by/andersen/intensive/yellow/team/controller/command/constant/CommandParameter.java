package by.andersen.intensive.yellow.team.controller.command.constant;

public enum CommandParameter {
	COMMAND_PARAM("command"),
	PAGE_PARAMETER("page"),
	USER_ID_PARAMETER("id"),
	USERNAME_PARAMETER("username"),
	OLD_USERNAME_PARAMETER("old_username"),
	CURRENT_USERNAME_PARAMETER("currentUserName"),
	FIRSTNAME_PARAMETER("firstName"),
	SECONDNAME_PARAMETER("secondName"),
	LASTNAME_PARAMETER("lastName"),
	AGE_PARAMETER("age"),
	PHONE_PARAMETER("phoneNumber"),
	USER_EMAIL_PARAMETER("email"),
	USER_ROLE_PARAMETER("role"),
	
	REPORT_ID_PARAMETER("reportId"),
	REPORT_TITLE_PARAMETER("reportTitle"),
	REPORT_BODY_PARAMETER("reportBody"),
	TIME_COSTS_PARAMETER("laborCosts"),
	OLD_REPORT_TITLE_PARAMETER("oldReportTitle"),
	OLD_REPORT_FILTER_DATE_PARAMETER("filterDate"),
	
	JSON_REPORT_DATE("reportDate");
	
	String parameterName;
	
	CommandParameter(String parameterValue) {
		this.parameterName = parameterValue;
	}
	
	public String getParameterName() {
		return this.parameterName;
	}
}
