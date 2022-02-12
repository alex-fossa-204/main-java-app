package by.andersen.intensive.bakulin.controller.command.constant;

public enum MessageEnum {
	
	NONE_MESSAGE("NONE"),
	
	COMMAND_ERROR_MESSAGE("Command Not Found."),
	SERVICE_ERROR_MESSAGE("Service error. Tell The Adminstator"),
	
	USER_ADDED_SUCCESSFULLY_MESSAGE("User Was Added Successfully"),
	USER_ADD_FAILED_MESSAGE("User Add Was Failed"),
	
	USER_UPDATED_SUCCESSFULLY_MESSAGE("User Was Updated Successfully"),
	USER_UPDATE_FAILED_MESSAGE("User Update Was Failed"),
	
	USER_DELETED_SUCCESSFULLY_MESSAGE("User Was Deleted Successfully"),
	USER_DELETE_FAILED_MESSAGE("User Delte Was Failed");
	
	
	
	String message;
	
	MessageEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
