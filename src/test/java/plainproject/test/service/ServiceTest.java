package plainproject.test.service;

import java.util.List;

import org.junit.Test;

import by.andersen.intensive.yellow.entity.User;
import by.andersen.intensive.yellow.service.IUserService;
import by.andersen.intensive.yellow.service.exception.ServiceException;
import by.andersen.intensive.yellow.service.impl.UserService;

public class ServiceTest {
	
	String username = "bigWolf13";
	
	@Test
	public void testServiceAddUser() {
		System.out.println("Service Add User:");
		
		IUserService userService = new UserService();
		try {
			boolean result = userService.addUser(username, "Wolf", "Wolfov", "Wolkowich", 13, "+142352326", "wolf@gmail.com");
			if(result) {
				System.out.println("Success Add");
			}
			if(!result) {
				System.out.println("Failure Add");
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\n");
	}
	
	@Test
	public void testServiceDeleteUser() {
		System.out.println("Service Delete User:");
		
		IUserService userService = new UserService();
		User userToDelete = null;
		try {
			System.out.println("\tService Find By UserName User:");
			userToDelete = userService.getUserByUserName(username);
			System.out.println("\tFind by username: " + userToDelete);
			if(userToDelete != null) {
				System.out.println("\tSuccess");
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		try {
			boolean result = userService.deleteUser(userToDelete.getId());
			if(result) {
				System.out.println("Success Delete");
			}
			if(!result) {
				System.out.println("Failure Delete");
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\n");
	}
	
	@Test
	public void testServiceFindAllUsers() {
		System.out.println("Service Find All Users:");
		
		IUserService userService = new UserService();
		List<User> users = null;
		try {
			users = userService.getAllUsers();
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		
		users.stream().forEach(e -> System.out.println(e));

		System.out.println("\n");
	}
	
	@Test
	public void testServiceFindAllUsersPageable() {
		System.out.println("Service Find All Users Pageable:");
		int pageNum = 2;
		int recordsPerPage = 5;
		int recordsQuantity = 0;
		
		IUserService userService = new UserService();
		List<User> users = null;
		try {
			recordsQuantity = userService.getUsersQuanity();
			users = userService.getAllUsersPageable(pageNum, recordsPerPage, recordsQuantity);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		
		users.stream().forEach(e -> System.out.println(e));

		System.out.println("\n");
	}
}
