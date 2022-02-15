package by.andersen.intensive.yellow.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.andersen.intensive.yellow.dao.IUserDAO;
import by.andersen.intensive.yellow.dao.exception.DAOException;
import by.andersen.intensive.yellow.dao.sql.connection.manager.ConnectionManager;
import by.andersen.intensive.yellow.dao.sql.impl.SqlUserDAO;
import by.andersen.intensive.yellow.entity.RoleEnum;
import by.andersen.intensive.yellow.entity.User;
import by.andersen.intensive.yellow.service.IUserService;
import by.andersen.intensive.yellow.service.exception.ServiceException;

public class UserService implements IUserService {

	public UserService() {
		super();
	}

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
	public List<User> getAllUsersPageable(int page, int recordsPerPage, int totalPages) throws ServiceException {
		List<User> usersPageable = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());

			List<User> allUsers = userDAO.findAll();
			usersPageable = paginateUsers(page, recordsPerPage, allUsers, totalPages);

		} catch (DAOException daoException) {
			throw new ServiceException(daoException.getMessage(), daoException);
		} catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		return usersPageable;
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
	public boolean updateUser(String oldUserName, String userName, String firstName, String secondName, String lastName, int age,
			String phoneNumber, String emailAddress, String userRole) throws ServiceException {
		boolean result = false;
		User userToUpdate = null;
		try (ConnectionManager connectionManager = new ConnectionManager()) {
			IUserDAO userDAO = new SqlUserDAO(connectionManager.getConnection());
			userToUpdate = userDAO.findByUserName(oldUserName);
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

	private List<User> paginateUsers(int page, int recordsPerPage, List<User> allUsers, int totalPages) {
		List<User> result = new ArrayList<>();
		int allRecords = allUsers.size();
		int recordCounter = 0;
		if (page < totalPages) {
			if (page == 1) {
				for (int record = 0; record < recordsPerPage; record++) {
					User user = allUsers.get(record);
					result.add(user);
					++recordCounter;
				}
			}
			if (page > 1) {
				recordCounter = recordsPerPage * (page - 1);
				for (int record = recordCounter; record < page * recordsPerPage; record++) {
					User user = allUsers.get(record);
					result.add(user);
					++recordCounter;
				}
			}
		}
		if (page == totalPages) {
			recordCounter = recordsPerPage * (page - 1);
			for (int record = recordCounter; record < allRecords; record++) {
				User user = allUsers.get(record);
				result.add(user);
				++recordCounter;
			}
		}
		return result;
	}

	@Override
	public int getUsersQuanity() throws ServiceException {
		int usersQuantity = 0;
		try {
			List<User> users = getAllUsers();
			usersQuantity = users.size();
		} catch (ServiceException exception) {
			throw exception;
		}
		return usersQuantity;
	}

}
