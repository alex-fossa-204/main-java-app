package by.andersen.intensive.yellow.team.controller.page;

import by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum;

public class Page {
	
	private String pageUrl;
	
	private boolean isRedirect;
	
	private String message;
	
	public Page(String pageUrl, boolean isRedirect, String message) {
		super();
		this.pageUrl = pageUrl;
		this.isRedirect = isRedirect;
		this.message = message;
	}

	public Page(String pageUrl, boolean isRedirect) {
		super();
		this.pageUrl = pageUrl;
		this.isRedirect = isRedirect;
		this.message = MessageEnum.NONE_MESSAGE.getMessage();
	}

	public Page() {
		super();
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
