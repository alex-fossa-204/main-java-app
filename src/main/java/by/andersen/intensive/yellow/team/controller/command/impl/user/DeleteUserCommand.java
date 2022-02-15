package by.andersen.intensive.yellow.team.controller.command.impl.user;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.service.IUserService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.UserService;

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
				resultPage = new Page(USERS_PAGE_PATH.getPagePath(), false, USER_DELETED_SUCCESSFULLY_MESSAGE.getMessage());
			}
			if(!isDeleteSuccessfull) {
				resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, USER_DELETE_FAILED_MESSAGE.getMessage());
			}
			
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		
		return resultPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeleteUserCommand []");
		return builder.toString();
	}
	
	

}
