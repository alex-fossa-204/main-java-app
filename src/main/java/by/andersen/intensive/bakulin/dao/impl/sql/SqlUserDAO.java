package by.andersen.intensive.bakulin.dao.impl.sql;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.bakulin.dao.IUserDAO;
import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.User;

public class SqlUserDAO extends SqlAbstractDAO<User> implements IUserDAO {

	public SqlUserDAO(Connection connection) {
		super(connection);
	}

	@Override
	public User findByUserName(String userName) throws DAOException {
		return null;
	}

	@Override
	public Map<String, String> initializeBaseQueries() {
		return null;
	}

	@Override
	public List<String> getEntityParameters(User e) {
		return null;
	}

	@Override
	public User buildEntity() throws DAOException {
		return null;
	}

}
