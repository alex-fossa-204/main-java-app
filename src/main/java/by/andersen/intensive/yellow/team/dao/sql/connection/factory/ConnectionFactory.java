package by.andersen.intensive.yellow.team.dao.sql.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import by.andersen.intensive.yellow.team.dao.sql.connection.constant.ConnectionConstant;

public class ConnectionFactory {
	
	
	private static final String CONNECTION_WAS_NOT_CREATED_EXCEPTION_MESSAGE = "Conncetion was not created";
	
	private static String SQL_CONNECTION_EXCEPTION_MESSAGE = "Conncetion was not created %s";
	
	private ConnectionFactory() {
		super();
	}
	
	public static Connection newInstance() {
		Connection connection = null;
		registerConnectionDriver();
		try {
			connection = DriverManager.getConnection(ConnectionConstant.DATABASE_URL_BUNDLE_KEY, ConnectionPropertiesFactory.newInstance());
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(String.format(SQL_CONNECTION_EXCEPTION_MESSAGE, e.getMessage()));
		}
		
		return connection;
	}
	
	private static void registerConnectionDriver() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (SQLException e) {
			throw new ExceptionInInitializerError(CONNECTION_WAS_NOT_CREATED_EXCEPTION_MESSAGE);
		}
	}
	
	
}
