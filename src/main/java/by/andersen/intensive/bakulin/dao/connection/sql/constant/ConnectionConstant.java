package by.andersen.intensive.bakulin.dao.connection.sql.constant;

import java.util.ResourceBundle;

public class ConnectionConstant {
	
	public static final String RESOURCE_BUNDLE_FILE_NAME = "database_connection";
	
	public static final String DATABASE_USER_BUNDLE_KEY = "database.user";
	
	public static final String DATABASE_PASSWORD_BUNDLE_KEY = "database.password";
	
	public static final String CONNECTION_POOL_QUEUE_SIZE_BUNDLE_KEY = "database.poolSize";
	
	public static final String DATABASE_URL_BUNDLE_KEY = "database.url";
	
	public static final String DATABASE_AUTO_RECONNECT_BUNDLE_KEY = "database.autoReconnect";
	
	public static final String DATABASE_CHARACTER_ENCODING_BUNDLE_KEY = "database.encoding";
	
	public static final String DATABASE_UNICODE_BUNDLE_KEY = "database.useUnicode";
	
	public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE_NAME);

}
