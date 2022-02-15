package by.andersen.intensive.yellow.dao.sql.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.yellow.dao.IUserDAO;
import by.andersen.intensive.yellow.dao.exception.DAOException;
import by.andersen.intensive.yellow.entity.User;

public class SqlUserDAO extends SqlAbstractDAO<User> implements IUserDAO {
	
	private static final String USER_USERNAME_COL_LABEL = "username";
	private static final String USER_FIRSTNAME_COL_LABEL = "user_firstname";
	private static final String USER_SECONDNAME_COL_LABEL = "user_secondname";
	private static final String USER_LASTNAME_COL_LABEL = "user_lastname";
	private static final String USER_AGE_COL_LABEL = "user_age";
	private static final String USER_PHONE_COL_LABEL = "user_phone";
	private static final String USER_EMAIL_COL_LABEL = "user_email";
	private static final String USER_ROLE_COL_LABEL = "user_role";
	
	private static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM users ORDER BY id ASC";
	private static final String SELECT_USERS_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
	private static final String SELECT_USERS_BY_USERNAME_QUERY = "SELECT * FROM users WHERE username=?";
	private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM users WHERE id=?";
	private static final String INSERT_USER_QUERY = "INSERT INTO users (username, user_firstname, user_secondname, user_lastname, user_age, user_phone, user_email, user_role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_USER_QUERY = "UPDATE users SET username=?, user_firstname=?, user_secondname=?, user_lastname=?, user_age=?, user_phone=?, user_email=?, user_role=? WHERE id = ?";
	
	public SqlUserDAO(Connection connection) {
		super(connection);
	}

	@Override
	public User findByUserName(String userName) throws DAOException {
		User user = null;
		try (PreparedStatement preparedStatement = prepareStatementForSqlQuery(SELECT_USERS_BY_USERNAME_QUERY, userName)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				user = buildEntity(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return user;
	}

	@Override
	public User buildEntity(ResultSet resultSet) throws DAOException {
		User user = new User();
		try {
			long id = resultSet.getLong(ID_COLUMN_LABEL);
			user.setId(id);
			
			String userName = resultSet.getString(USER_USERNAME_COL_LABEL);
			user.setUserName(userName);
			
			String firstName = resultSet.getString(USER_FIRSTNAME_COL_LABEL);
			user.setFirstName(firstName);
			
			String secondName = resultSet.getString(USER_SECONDNAME_COL_LABEL);
			user.setSecondName(secondName);
			
			String lastName = resultSet.getString(USER_LASTNAME_COL_LABEL);
			user.setLastName(lastName);
			
			int age = resultSet.getInt(USER_AGE_COL_LABEL);
			user.setAge(age);
			
			String phoneNumber = resultSet.getString(USER_PHONE_COL_LABEL);
			user.setPhoneNumber(phoneNumber);
			
			String email = resultSet.getString(USER_EMAIL_COL_LABEL);
			user.setEmailAddress(email);
			
			String userRole = resultSet.getString(USER_ROLE_COL_LABEL);
			user.setUserRole(userRole);
			
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return user;
	}
	
	@Override
	public Map<String, String> initializeBaseQueries() {
		Map<String, String> baseQueries = new HashMap<String, String>();
		baseQueries.put(QUERY_KEY_SELECT_ALL, SELECT_ALL_USERS_QUERY);
		baseQueries.put(QUERY_KEY_SELECT_BY_ID, SELECT_USERS_BY_ID_QUERY);
		baseQueries.put(QUERY_KEY_DELETE_BY_ID, DELETE_USER_BY_ID_QUERY);
		baseQueries.put(QUERY_KEY_INSERT_ENTITY, INSERT_USER_QUERY);
		baseQueries.put(QUERY_KEY_UPDATE_ENTITY, UPDATE_USER_QUERY);
		return baseQueries;
	}

	@Override
	public List<Object> getEntityParameters(User e) {
		List<Object> entityParameters = new ArrayList<Object>();
		
		String userName = e.getUserName();
		entityParameters.add(userName);
		
		String firstName = e.getFirstName();
		entityParameters.add(firstName);
		
		String secondName = e.getSecondName();
		entityParameters.add(secondName);
		
		String lastName = e.getLastName();
		entityParameters.add(lastName);
		
		Integer age = e.getAge();
		entityParameters.add(age);
		
		String phoneNumber = e.getPhoneNumber();
		entityParameters.add(phoneNumber);
		
		String email = e.getEmailAddress();
		entityParameters.add(email);
		
		String userRole = e.getUserRole();
		entityParameters.add(userRole);
		
		return entityParameters;
	}

}
