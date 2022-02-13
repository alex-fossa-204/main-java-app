package by.andersen.intensive.bakulin.controller.command.impl.user;

import static by.andersen.intensive.bakulin.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.bakulin.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.bakulin.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.bakulin.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.page.Page;
import by.andersen.intensive.bakulin.entity.User;
import by.andersen.intensive.bakulin.service.IUserService;
import by.andersen.intensive.bakulin.service.exception.ServiceException;
import by.andersen.intensive.bakulin.service.impl.UserService;

public class ShowUserInfoCommand implements Command{

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		
		String username = httpServletRequest.getParameter(USERNAME_PARAMETER.getParameterName());
		IUserService userService = new UserService();
		try {
			User user = userService.getUserByUserName(username);
			
			if(user != null) {
				resultPage = new Page(USER_EDIT_FORM_PATH.getPagePath(), false);
				httpServletRequest.setAttribute(USER_ATTRIBUTE.getAttributeName(), user);
				httpServletRequest.setAttribute(OLD_USERNAME_ATTRIBUTE.getAttributeName(), user.getUserName());
				
			}
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}

}
