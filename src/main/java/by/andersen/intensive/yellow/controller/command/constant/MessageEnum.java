package by.andersen.intensive.yellow.controller.command.constant;

public enum MessageEnum {
	
	NONE_MESSAGE("NONE"),
	
	_MESSAGE(" Message"),
	
	PRESS_HERE_TO_CONTINUE(". Press Here To Continue"),
	
	COMMAND_ERROR_MESSAGE("Command Error Message"),
	SERVICE_ERROR_MESSAGE("Service Error Message"),
	
	USER_ADDED_SUCCESSFULLY_MESSAGE("User Added Successfully Message"),
	USER_ADD_FAILED_MESSAGE("User Add Failed Message"),
	
	USER_UPDATED_SUCCESSFULLY_MESSAGE("User Updated Successfully Message"),
	USER_UPDATE_FAILED_MESSAGE("User Update Failed Message"),
	
	USER_DELETED_SUCCESSFULLY_MESSAGE("User Deleted Successfully Message"),
	USER_DELETE_FAILED_MESSAGE("User Delete Failed Message");
	
	
	
	String message;
	
	MessageEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
