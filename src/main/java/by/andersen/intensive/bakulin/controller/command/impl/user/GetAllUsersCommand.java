package by.andersen.intensive.bakulin.controller.command.impl.user;

import javax.servlet.http.HttpServletRequest;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.page.Page;
import by.andersen.intensive.bakulin.entity.User;
import by.andersen.intensive.bakulin.service.IUserService;
import by.andersen.intensive.bakulin.service.exception.ServiceException;
import by.andersen.intensive.bakulin.service.impl.UserService;

import static by.andersen.intensive.bakulin.controller.command.constant.CommandParameter.*;
import static by.andersen.intensive.bakulin.controller.command.constant.CommandAttribute.*;
import static by.andersen.intensive.bakulin.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.bakulin.controller.page.constant.PageEnum.*;

import java.util.List;

public class GetAllUsersCommand implements Command {
	
    private static final int RECORDS_PER_PAGE = 5;
    
    private static final int FIRST_PAGE_INDEX = 1;

	@Override
	public Page execute(HttpServletRequest httpServletRequest) {
		Page resultPage = null;
		
		IUserService userService = new UserService();
		int pageIndex = FIRST_PAGE_INDEX;
		int pagesQuantity = 0;
		String pageReqParameterValue = httpServletRequest.getParameter(PAGE_PARAMETER.getParameterName());
		if(pageReqParameterValue != null) {
			pageIndex = Integer.parseInt(pageReqParameterValue);
		}
		try {
			int recordsQuantity = userService.getUsersQuanity();
			pagesQuantity = calculatePagesQuantity(recordsQuantity, RECORDS_PER_PAGE);
			List<User> usersPage = userService.getAllUsersPageable(pageIndex, RECORDS_PER_PAGE, pagesQuantity);
			httpServletRequest.setAttribute(NUMBER_OF_PAGES_ATTRIBUTE.getAttributeValue(), pagesQuantity);
			httpServletRequest.setAttribute(CURRENT_PAGE_INDEX.getAttributeValue(), pageIndex);
			httpServletRequest.setAttribute(USERS_PAGE_CONTENT_ATTRIBUTE.getAttributeValue(), usersPage);
			resultPage = new Page(USERS_PAGE_PATH.getPagePath(), false);
		} catch (ServiceException e) {
			resultPage = new Page(ERROR_PAGE_PATH.getPagePath(), true, SERVICE_ERROR_MESSAGE.getMessage());
		}
		return resultPage;
	}
	
	private int calculatePagesQuantity(int recordsQuantity, int recordsPerPage) {
		return (int) Math.ceil(recordsQuantity * 1.0 / recordsPerPage);
	}

}
