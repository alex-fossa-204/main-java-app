package by.andersen.intensive.bakulin.controller.command.constant;

public enum CommandAttribute {
	
	USER_ATTRIBUTE("user"),
	MESSAGE_ATTRIBUTE("message"),
	USERS_PAGE_CONTENT_ATTRIBUTE("list"),
	NUMBER_OF_PAGES_ATTRIBUTE("numberOfPages"),
	CURRENT_PAGE_INDEX("currentPageIndex");
	
	String attributeValue;
	
	CommandAttribute(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
	public String getAttributeName() {
		return this.attributeValue;
	}
}
