package by.andersen.intensive.yellow.team.controller.command.impl.user;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.entity.impl.User;
import by.andersen.intensive.yellow.team.service.IUserService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.UserService;

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
