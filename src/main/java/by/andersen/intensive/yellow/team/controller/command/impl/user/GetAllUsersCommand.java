package by.andersen.intensive.yellow.team.controller.command.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.yellow.team.controller.command.Command;
import by.andersen.intensive.yellow.team.controller.page.Page;
import by.andersen.intensive.yellow.team.entity.impl.User;
import by.andersen.intensive.yellow.team.service.IUserService;
import by.andersen.intensive.yellow.team.service.exception.ServiceException;
import by.andersen.intensive.yellow.team.service.impl.UserService;

import static by.andersen.intensive.yellow.team.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.yellow.team.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.yellow.team.controller.page.constant.PageEnum.*;

import java.util.List;

public class GetAllUsersCommand implements Command {
	
    private static final int RECORDS_PER_PAGE = 7;
    
    private static final int FIRST_PAGE_INDEX = 1;

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		
		IUserService userService = new UserService();
		int pageIndex = FIRST_PAGE_INDEX;
		int pagesQuantity = 0;
		String pageReqParameterValue = httpServletRequest.getParameter(PAGE_PARAMETER.getParameterName());
		if(pageReqParameterValue != null) {
			pageIndex = Integer.valueOf(pageReqParameterValue);
		}
		try {
			int recordsQuantity = userService.getUsersQuanity();
			pagesQuantity = calculatePagesQuantity(recordsQuantity, RECORDS_PER_PAGE);
			List<User> usersPage = userService.getAllUsersPageable(pageIndex, RECORDS_PER_PAGE, pagesQuantity);
			httpServletRequest.setAttribute(NUMBER_OF_PAGES_ATTRIBUTE.getAttributeName(), pagesQuantity);
			httpServletRequest.setAttribute(CURRENT_PAGE_INDEX.getAttributeName(), pageIndex);
			httpServletRequest.setAttribute(USERS_PAGE_CONTENT_ATTRIBUTE.getAttributeName(), usersPage);
			resultPage = new Page(USERS_PAGE_PATH.getPagePath(), false);
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}
	
	private int calculatePagesQuantity(int recordsQuantity, int recordsPerPage) {
		return (int) Math.ceil(recordsQuantity * 1.0 / recordsPerPage);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAllUsersCommand []");
		return builder.toString();
	}
	
	

}
