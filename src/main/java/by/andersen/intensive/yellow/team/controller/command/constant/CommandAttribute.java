package by.andersen.intensive.yellow.team.controller.command.constant;

public enum CommandAttribute {
	
	USER_ATTRIBUTE("user"),
	USER_NAME_ATTRIBUTE("username"),
	OLD_USERNAME_ATTRIBUTE("username_old"),
	CURRENT_USERNAME_ATTRIBUTE("currentUserName"),
	MESSAGE_ATTRIBUTE("message"),
	USERS_PAGE_CONTENT_ATTRIBUTE("list"),
	NUMBER_OF_PAGES_ATTRIBUTE("numberOfPages"),
	CURRENT_PAGE_INDEX("currentPageIndex"),
	REPORT_ATTRIBUTE("report"),
	OLD_REPORT_TITLE_ATTRIBUTE("oldReportTitle"),
	REPORT_ID_ATTRIBUTE("reportId"),
	JSON_DATA_ATTRIBUTE("jsonData");
	
	String attributeValue;
	
	CommandAttribute(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public String getAttributeName() {
		return this.attributeValue;
	}
}
