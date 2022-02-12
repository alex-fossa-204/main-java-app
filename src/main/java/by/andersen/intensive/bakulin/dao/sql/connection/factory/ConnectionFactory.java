package by.andersen.intensive.bakulin.dao.sql.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.ResourceBundle;

import com.mysql.jdbc.Driver;

import by.andersen.intensive.bakulin.dao.sql.connection.constant.ConnectionConstant;

public class ConnectionFactory {
	
	
	private static final String CONNECTION_WAS_NOT_CREATED_EXCEPTION_MESSAGE = "Conncetion was not created";
	
	private static String SQL_CONNECTION_EXCEPTION_MESSAGE = "Conncetion was not created %s";
	
	private ConnectionFactory() {
		super();
	}
	
	public static Connection newInstance() {
		Connection connection = null;
		registerConnectionDriver();
		//String dbUrl = ConnectionConstant.RESOURCE_BUNDLE.getString(ConnectionConstant.DATABASE_URL_BUNDLE_KEY);
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
