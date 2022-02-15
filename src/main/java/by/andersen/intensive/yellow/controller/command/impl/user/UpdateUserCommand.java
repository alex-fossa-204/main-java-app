package by.andersen.intensive.yellow.controller.command.impl.user;

import static by.andersen.intensive.yellow.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.controller.command.Command;
import by.andersen.intensive.yellow.controller.page.Page;
import by.andersen.intensive.yellow.service.IUserService;
import by.andersen.intensive.yellow.service.exception.ServiceException;
import by.andersen.intensive.yellow.service.impl.UserService;

public class UpdateUserCommand implements Command{

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		boolean isUpdateSuccessfull = false;
		String oldUserName = httpServletRequest.getParameter(OLD_USERNAME_PARAMETER.getParameterName());
		String username = httpServletRequest.getParameter(USERNAME_PARAMETER.getParameterName());
		String firstName = httpServletRequest.getParameter(FIRSTNAME_PARAMETER.getParameterName());
		String secondName = httpServletRequest.getParameter(SECONDNAME_PARAMETER.getParameterName());
		String lastName = httpServletRequest.getParameter(LASTNAME_PARAMETER.getParameterName());
		int age = Integer.valueOf(httpServletRequest.getParameter(AGE_PARAMETER.getParameterName()));
		String phoneNumber = httpServletRequest.getParameter(PHONE_PARAMETER.getParameterName());
		String emailAddress = httpServletRequest.getParameter(USER_EMAIL_PARAMETER.getParameterName());
		String role = httpServletRequest.getParameter(USER_ROLE_PARAMETER.getParameterName());
		
		IUserService userService = new UserService();
		try {
			isUpdateSuccessfull = userService.updateUser(oldUserName, username, firstName, secondName, lastName, age, phoneNumber, emailAddress, role);
			if(isUpdateSuccessfull) {
				resultPage = new Page(USERS_PAGE_PATH.getPagePath(), false, USER_UPDATED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isUpdateSuccessfull) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, USER_UPDATE_FAILED_MESSAGE.getMessage());
			}
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateUserCommand []");
		return builder.toString();
	}
	
	

}
