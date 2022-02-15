package by.andersen.intensive.yellow.team.dao.sql.connection.constant;

import static by.andersen.intensive.yellow.team.dao.sql.connection.constant.PropertiesConstant.*;

import java.util.ResourceBundle;

public class ConnectionConstant {
	
	public static final String RESOURCE_BUNDLE_FILE_NAME = "database_connection";
	
	public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE_NAME);
	
	public static final String DATABASE_USER_BUNDLE_KEY = RESOURCE_BUNDLE.getString(DATABASE_USER_PROPERTY.getPropertyKey());
	
	public static final String DATABASE_PASSWORD_BUNDLE_KEY = RESOURCE_BUNDLE.getString(DATABASE_PASSWORD_PROPERTY.getPropertyKey());
	
	public static final String CONNECTION_POOL_QUEUE_SIZE_BUNDLE_KEY = RESOURCE_BUNDLE.getString(CONNECTION_POOL_QUEUE_SIZE_PROPERTY.getPropertyKey());
	
	public static final String DATABASE_URL_BUNDLE_KEY = RESOURCE_BUNDLE.getString(DATABASE_URL_PROPERTY.getPropertyKey());
	
	public static final String DATABASE_AUTO_RECONNECT_BUNDLE_KEY = RESOURCE_BUNDLE.getString(DATABASE_AUTO_RECONNECT_PROPERTY.getPropertyKey());
	
	public static final String DATABASE_CHARACTER_ENCODING_BUNDLE_KEY = RESOURCE_BUNDLE.getString(DATABASE_CHARACTER_ENCODING_PROPERTY.getPropertyKey());
	
	public static final String DATABASE_UNICODE_BUNDLE_KEY = RESOURCE_BUNDLE.getString(DATABASE_UNICODE_PROPERTY.getPropertyKey());
	
	
}
