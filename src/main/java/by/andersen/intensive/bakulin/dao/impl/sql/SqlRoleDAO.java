package by.andersen.intensive.bakulin.dao.impl.sql;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import by.andersen.intensive.bakulin.dao.IRoleDAO;
import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.Role;

public class SqlRoleDAO extends SqlAbstractDAO<Role> implements IRoleDAO {

	public SqlRoleDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Role findRoleByName(String roleName) throws DAOException {
		return null;
	}

	@Override
	public Map<String, String> initializeBaseQueries() {
		return null;
	}

	@Override
	public List<String> getEntityParameters(Role e) {
		return null;
	}

	@Override
	public Role buildEntity() throws DAOException {
		return null;
	}

}
