package by.andersen.intensive.yellow.team.controller.page.constant;

public enum PageEnum {
	
	INDEX_PAGE_PATH("/index.jsp"),
	USERS_PAGE_PATH("/users-page.jsp"),
	ERROR_PAGE_PATH("/error.jsp"),
	USER_EDIT_FORM_PATH("/user-edit-page.jsp"),
	REPORTS_PAGE("/reports-page.jsp"),
	REPORT_FORM_PAGE("/report-form-page.jsp"),
	DAEMON_PAGE("/daemon-page.jsp"),
	JSON_REPORTS_PAGE("/json-page.jsp");
	
	String pagePath;
	
	PageEnum(String pageName) {
		this.pagePath = pageName;
	}
	
	public String getPagePath() {
		return this.pagePath;
	}
}
