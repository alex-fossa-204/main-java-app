package by.andersen.intensive.bakulin.controller.command.constant;

public enum CommandParameter {
	COMMAND_PARAM("commmand"),
	PAGE_PARAMETER("page"),
	USER_ID_PARAMETER("id"),
	USERNAME_PARAMETER("username"),
	FIRSTNAME_PARAMETER("user_firstname"),
	SECONDNAME_PARAMETER("user_secondname"),
	LASTNAME_PARAMETER("user_lastname"),
	AGE_PARAMETER("user_age"),
	PHONE_PARAMETER("user_phone"),
	USER_EMAIL_PARAMETER("user_email"),
	USER_ROLE_PARAMETER("user_role");
	
	String parameterName;
	
	CommandParameter(String parameterValue) {
		this.parameterName = parameterValue;
	}
	
	public String getParameterName() {
		return this.parameterName;
	}
}
