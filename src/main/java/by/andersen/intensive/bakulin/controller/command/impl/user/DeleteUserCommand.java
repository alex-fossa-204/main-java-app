package by.andersen.intensive.bakulin.controller.command.impl.user;

import static by.andersen.intensive.bakulin.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.bakulin.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.bakulin.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.page.Page;
import by.andersen.intensive.bakulin.service.IUserService;
import by.andersen.intensive.bakulin.service.exception.ServiceException;
import by.andersen.intensive.bakulin.service.impl.UserService;

public class DeleteUserCommand implements Command{

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		boolean isDeleteSuccessfull = false;
		
		String userId = httpServletRequest.getParameter(USER_ID_PARAMETER.getParameterName());
		long id = Long.valueOf(userId);
		
		IUserService userService = new UserService();
		try {
			isDeleteSuccessfull = userService.deleteUser(id);
			if(isDeleteSuccessfull) {
				resultPage = new Page(USERS_PAGE_PATH.getPagePath(), false, USER_ADDED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isDeleteSuccessfull) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, USER_ADD_FAILED_MESSAGE.getMessage());
			}
			
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		
		return resultPage;
	}

}
