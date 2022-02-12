package by.andersen.intensive.bakulin.controller.command.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.page.Page;
import by.andersen.intensive.bakulin.service.IUserService;
import by.andersen.intensive.bakulin.service.exception.ServiceException;
import by.andersen.intensive.bakulin.service.impl.UserService;

import static by.andersen.intensive.bakulin.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.bakulin.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.bakulin.controller.page.constant.PageEnum.*;

public class AddUserCommand implements Command {

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		boolean isAddSuccessfull = false;
		
		String username = httpServletRequest.getParameter(USERNAME_PARAMETER.getParameterName());
		String firstName = httpServletRequest.getParameter(FIRSTNAME_PARAMETER.getParameterName());
		String secondName = httpServletRequest.getParameter(SECONDNAME_PARAMETER.getParameterName());
		String lastName = httpServletRequest.getParameter(LASTNAME_PARAMETER.getParameterName());
		int age = Integer.valueOf(httpServletRequest.getParameter(AGE_PARAMETER.getParameterName()));
		String phoneNumber = httpServletRequest.getParameter(USERNAME_PARAMETER.getParameterName());
		String emailAddress = httpServletRequest.getParameter(USER_EMAIL_PARAMETER.getParameterName());
		
		IUserService userService = new UserService();
		try {
			isAddSuccessfull = userService.addUser(username, firstName, secondName, lastName, age, phoneNumber, emailAddress);
			if(isAddSuccessfull) {
				resultPage = new Page(USERS_PAGE_PATH.getPagePath(), false, USER_DELETED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isAddSuccessfull) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, USER_DELETE_FAILED_MESSAGE.getMessage());
			}
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		
		return resultPage;
	}

}
