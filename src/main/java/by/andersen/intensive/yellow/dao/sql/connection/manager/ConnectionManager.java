package by.andersen.intensive.yellow.dao.sql.connection.manager;

import java.sql.Connection;
import java.sql.SQLException;

import by.andersen.intensive.yellow.dao.sql.connection.pool.ConnectionPool;

public class ConnectionManager implements AutoCloseable {

	private static String TRANSACTION_START_FAILED_MESSAGE = "Transaction start failed: ?";

	private static String TRANSACTION_COMMIT_FAILED_MESSAGE = "Transaction commit failed: ?";

	private static String TRANSACTION_ROLLBACK_FAILED_MESSAGE = "Transaction rollback failed: ?";
	
	private static String TRANSACTION_END_FAILED_MESSAGE = "Transaction end failed: ?";

	private final Connection connection;

	private ConnectionPool connectionPool;

	public ConnectionManager() {
		connectionPool = ConnectionPool.getInstance();
		connection = connectionPool.getConnection();
	}

	public void startTransaction() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException sqlException) {
			System.err.println(String.format(TRANSACTION_START_FAILED_MESSAGE, sqlException.getMessage()));
		}
	}

	public void commitTransaction() {
		try {
			connection.commit();
			;
		} catch (SQLException sqlException) {
			System.err.println(String.format(TRANSACTION_COMMIT_FAILED_MESSAGE, sqlException.getMessage()));
		}
	}

	public void rollbackTransaction() {
		try {
			connection.rollback();
		} catch (SQLException sqlException) {
			System.err.println(String.format(TRANSACTION_ROLLBACK_FAILED_MESSAGE, sqlException.getMessage()));
		}
	}

	public void endTransaction() {
		try {
			connection.setAutoCommit(true);
		} catch (SQLException sqlException) {
			System.err.println(String.format(TRANSACTION_END_FAILED_MESSAGE, sqlException.getMessage()));
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void close() throws Exception {
		connectionPool.returnBackConnection(connection);
	}

}
