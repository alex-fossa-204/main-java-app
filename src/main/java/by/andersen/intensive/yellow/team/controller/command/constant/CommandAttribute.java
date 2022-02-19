package by.andersen.intensive.yellow.team.controller.command.constant;

public enum CommandAttribute {
	
	USER_ATTRIBUTE("user"),
	USER_NAME_ATTRIBUTE("username"),
	OLD_USERNAME_ATTRIBUTE("username_old"),
	CURRENT_USERNAME_ATTRIBUTE("currentUserName"),
	
	MESSAGE_ATTRIBUTE("message"),
	
	USERS_PAGE_CONTENT_ATTRIBUTE("list"),

	REPORT_ATTRIBUTE("report"),
	REPORTS_PAGE_CONTENT_ATTRIBUTE("list"),
	OLD_REPORT_TITLE_ATTRIBUTE("oldReportTitle"),
	REPORT_ID_ATTRIBUTE("reportId"),
	REPORT_DATE_ATTRIBUTE("reportDate"),
	
	NUMBER_OF_PAGES_ATTRIBUTE("numberOfPages"),
	CURRENT_PAGE_INDEX("currentPageIndex"),
	RECORDS_PER_PAGE_ATTRIBUTE("recordsPerPage"),
	COMMAND_TYPE_ATTRIBUTE("command"),
	
	JSON_DATA_ATTRIBUTE("jsonData");
	
	String attributeValue;
	
	CommandAttribute(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public String getAttributeName() {
		return this.attributeValue;
	}
}
