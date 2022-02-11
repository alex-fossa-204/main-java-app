package by.andersen.intensive.bakulin.service.impl;

import java.util.List;

import by.andersen.intensive.bakulin.dao.IUserDAO;
import by.andersen.intensive.bakulin.dao.connection.sql.manager.ConnectionManager;
import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.dao.impl.sql.SqlUserDAO;
import by.andersen.intensive.bakulin.entity.RoleEnum;
import by.andersen.intensive.bakulin.entity.User;
import by.andersen.intensive.bakulin.service.IUserService;
import by.andersen.intensive.bakulin.service.exception.ServiceException;

public class UserService implements IUserService {

	@Override
	public boolean addUser(String userName, String firstName, String secondName, String lastName, int age,
			String phoneNumber, String emailAddress) throws ServiceException {
		boolean result = false;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());
			User user = new User(userName, firstName, secondName, lastName, age, phoneNumber, emailAddress);
			user.setUserRole(RoleEnum.USER.name());
			result = userDAO.save(user);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return result;
	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		List<User> users = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());
			users = userDAO.findAll();
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return users;
	}

	@Override
	public User getUserByUserName(String username) throws ServiceException {
		User user = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());
			user = userDAO.findByUserName(username);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return user;
	}

	@Override
	public boolean updateUser(String userName, String firstName, String secondName, String lastName, int age,
			String phoneNumber, String emailAddress, String userRole) throws ServiceException {
		boolean result = false;
		User userToUpdate = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());
			userToUpdate = userDAO.findByUserName(userName);
			userToUpdate.setUserName(userName);
			userToUpdate.setFirstName(firstName);
			userToUpdate.setSecondName(secondName);
			userToUpdate.setLastName(lastName);
			userToUpdate.setAge(age);
			userToUpdate.setPhoneNumber(phoneNumber);
			userToUpdate.setEmailAddress(emailAddress);
			userToUpdate.setUserRole(userRole);
			result = userDAO.update(userToUpdate);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return result;
	}

	@Override
	public boolean deleteUser(long id) throws ServiceException {
		boolean result = false;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());
			result = userDAO.delete(id);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return result;
	}
}
