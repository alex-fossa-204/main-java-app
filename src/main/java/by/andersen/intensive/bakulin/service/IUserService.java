package by.andersen.intensive.bakulin.service;

import java.util.List;

import by.andersen.intensive.bakulin.entity.User;
import by.andersen.intensive.bakulin.service.exception.ServiceException;

public interface IUserService {
	
	boolean addUser(String userName, String firstName, String secondName, String lastName, int age, String phoneNumber, String emailAddress) throws ServiceException;
	
	List<User> getAllUsers() throws ServiceException;
	
	List<User> getAllUsersPageable(int page, int recordsNumber, int totalPages) throws ServiceException;
	
	int getUsersQuanity()throws ServiceException;
	
	User getUserByUserName(String username) throws ServiceException;
	
	boolean updateUser(String userName, String firstName, String secondName, String lastName, int age, String phoneNumber, String emailAddress, String userRole) throws ServiceException;
	
	boolean deleteUser(long id) throws ServiceException;
	
}
