package main.java.app.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import by.andersen.intensive.yellow.team.dao.IUserDAO;
import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.dao.sql.connection.manager.ConnectionManager;
import by.andersen.intensive.yellow.team.dao.sql.impl.SqlUserDAO;
import by.andersen.intensive.yellow.team.entity.impl.RoleEnum;
import by.andersen.intensive.yellow.team.entity.impl.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserDAO {

	ConnectionManager connectionManager = new ConnectionManager();
	
	String username = "bigWolf13";

	@Test
	public void testFindAll() {

		try (Connection connection = connectionManager.getConnection()) {
			IUserDAO userDao = new SqlUserDAO(connection);
			List<User> users = null;
			try {
				users = userDao.findAll();
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Find All:");
			users.stream().forEach(e -> System.out.println(e));
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}

	}

	@Test
	public void testFindByUserName() {
		try (Connection connection = connectionManager.getConnection()) {
			IUserDAO userDao = new SqlUserDAO(connection);
			String username = "dogeadmin16";
			User user = null;
			try {
				user = userDao.findByUserName(username);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Find by username: " + username);
			System.out.println(user);
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

	@Test
	public void testCreate() {
		System.out.println("Save User:");
		try (Connection connection = connectionManager.getConnection()) {
			IUserDAO userDao = new SqlUserDAO(connection);
			boolean isSaved = false;
			User user = new User(username, "Wolf", "Wolfov", "Wolkowich", 13, "+142352326", "wolf@gmail.com", RoleEnum.USER.name());
			System.out.println(user);
			try {
				isSaved = userDao.save(user);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			if (isSaved) {
				System.out.println("Saved to DB: " + user);
			}
			if (!isSaved) {
				System.out.println("Not Saved");
			}
			System.out.println("\n");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
	}

	@Test
	public void testDelete() {
		try (Connection connection = connectionManager.getConnection()) {
			IUserDAO userDao = new SqlUserDAO(connection);

			boolean isDeleted = false;
			User user = null;
			try {
				user = userDao.findByUserName(username);
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Find by username: " + username);
			System.out.println(user);

			try {
				isDeleted = userDao.delete(user.getId());
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			if (isDeleted) {
				System.out.println("Deleted from DB: " + user);
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		System.out.println("\n");
	}
	
	@Test
	public void testUpdate() {
		try (Connection connection = connectionManager.getConnection()) {
			IUserDAO userDao = new SqlUserDAO(connection);
			String username = "testusernameCH";
			String currentUserRole = null;
			String newUserRole = null;
			System.out.println("Update user: ");
			try {
				User user = userDao.findByUserName(username);
				System.out.println("Current user: " + user);
				
				currentUserRole = user.getUserRole();
				if(currentUserRole.equals(RoleEnum.ADMIN.name())) {
					newUserRole = RoleEnum.USER.name();
					user.setUserRole(newUserRole);
				}
				if(currentUserRole.equals(RoleEnum.USER.name())) {
					newUserRole = RoleEnum.ADMIN.name();
					user.setUserRole(newUserRole);
				}
				System.err.println("Updated user: " + user);
				userDao.update(user);
				
			} catch (DAOException e) {
				System.err.println(e.getMessage());
			}
			if(!currentUserRole.equals(newUserRole)) {
				System.out.println("Success");
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		System.out.println("\n");
	}

}
