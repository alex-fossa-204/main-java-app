package by.andersen.intensive.bakulin.dao.impl.sql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.sql.*;

import by.andersen.intensive.bakulin.dao.DAO;
import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.impl.Entity;

public abstract class SqlAbstractDAO<E extends Entity> implements DAO<E> {

	public static final String QUERY_KEY_SELECT_ALL = "SELECT_ALL";
	public static final String QUERY_KEY_SELECT_BY_ID = "SELECT_BY_ID";
	public static final String QUERY_KEY_DELETE_BY_ID = "DELETE_BY_ID";
	public static final String QUERY_KEY_INSERT_ENTITY = "INSERT_ENTITY";
	public static final String QUERY_KEY_UPDATE_ENTITY = "UPDATE_ENTITY";

	public static final String ID_COLUMN_LABEL = "id";
	public static final String NULL_PARAMETER = "null";
	public static final int EMPTY_RESULT = 0;
	
	
	private final Map<String, String> baseSQLQueries;
	private Connection connection;

	public SqlAbstractDAO(Connection connection) {
		this.connection = connection;
		this.baseSQLQueries = initializeBaseQueries();
	}

	@Override
	public boolean save(E e) throws DAOException {
		String sqlQuery = baseSQLQueries.get(QUERY_KEY_INSERT_ENTITY);
		List<String> entityParamenters = getEntityParameters(e);
		return executeSQLQuery(sqlQuery, entityParamenters);
	}

	@Override
	public E getById(long id) throws DAOException {
		E entity = null;
		String sqlQuery = baseSQLQueries.get(QUERY_KEY_SELECT_BY_ID);
		try (PreparedStatement preparedStatement = prepareStatementForSqlQuery(sqlQuery, id)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				entity = buildEntity();
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return entity;
	}

	@Override
	public List<E> findAll() throws DAOException {
		List<E> entitiesList = new ArrayList<E>();
		String sqlQuery = baseSQLQueries.get(QUERY_KEY_SELECT_ALL);
		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				E entity = buildEntity();
				entitiesList.add(entity);
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return entitiesList;
	}

	@Override
	public boolean update(E e) throws DAOException {
		List<String> entityParamenters = getEntityParameters(e);
		String sqlQuery = baseSQLQueries.get(QUERY_KEY_UPDATE_ENTITY);
		entityParamenters.add(String.valueOf(e.getId()));
		return executeSQLQuery(sqlQuery, entityParamenters);
	}

	@Override
	public boolean delete(long id) throws DAOException {
		String sqlQuery = baseSQLQueries.get(QUERY_KEY_DELETE_BY_ID);
		return executeSQLQuery(sqlQuery, id);
	}

	private boolean executeSQLQuery(String sqlQuery, Object... queryParameters) throws DAOException {
		boolean result = false;

		try (PreparedStatement preparedStatement = prepareStatementForSqlQuery(sqlQuery, queryParameters)) {
			int sqlQueryResult = preparedStatement.executeUpdate();

			result = sqlQueryResult != EMPTY_RESULT;

		} catch (SQLException sqlException) {

			throw new DAOException(sqlException.getMessage(), sqlException);
		}
		return result;
	}

	private PreparedStatement prepareStatementForSqlQuery(String sqlQuery, Object... queryParameters)
			throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);

			if (queryParameters != null) {

				int parameterIndex = 1;

				for (Object queryParameter : queryParameters) {
					boolean isQueryParameterNull = queryParameter == null;

					if (isQueryParameterNull) {
						preparedStatement.setNull(parameterIndex, Types.NULL);
					}

					if (!isQueryParameterNull) {
						preparedStatement.setObject(parameterIndex, queryParameter);
					}

					parameterIndex++;
				}
			}
		} catch (SQLException sqlException) {
			throw new DAOException(sqlException.getMessage(), sqlException);
		}

		return preparedStatement;
	}
	
	public abstract Map<String, String> initializeBaseQueries();

	public abstract List<String> getEntityParameters(E e);

	public abstract E buildEntity() throws DAOException;

}
