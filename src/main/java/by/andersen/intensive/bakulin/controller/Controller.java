package by.andersen.intensive.bakulin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.andersen.intensive.bakulin.controller.command.Command;
import by.andersen.intensive.bakulin.controller.command.constant.MessageEnum;
import by.andersen.intensive.bakulin.controller.command.manager.CommandManager;
import by.andersen.intensive.bakulin.controller.page.Page;

import static by.andersen.intensive.bakulin.controller.command.constant.MessageEnum.*;
import static by.andersen.intensive.bakulin.controller.command.constant.CommandAttribute.*;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = -2502761567261800362L;

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		processRequest(httpServletRequest, httpServletResponse);
	}

	@Override
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		processRequest(httpServletRequest, httpServletResponse);
	}
	
	private void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
		CommandManager commandManager = new CommandManager();
		Command command = commandManager.defineCommand(httpServletRequest);
		Page page = command.execute(httpServletRequest);
		
		boolean isRedirect = page.isRedirect();
		if(isRedirect) {
			redirect(page, httpServletRequest, httpServletResponse);
		}
		if(!isRedirect) {
			forward(page, httpServletRequest, httpServletResponse);
		}
		
	}
	
	private void redirect(Page page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		String redirectUrl = page.getPageUrl();
		httpServletResponse.sendRedirect(redirectUrl);
	}
	
	private void forward(Page page, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		String url = page.getPageUrl();
		String pageMessage = page.getMessage();
		if(!NONE_MESSAGE.getMessage().equals(pageMessage)) {
			String message = MessageEnum.valueOf(pageMessage).getMessage();
			httpServletRequest.setAttribute(MESSAGE_ATTRIBUTE.getAttributeName(), message);
		}
		RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher(url);
		requestDispatcher.forward(httpServletRequest, httpServletResponse);
	}

}
