package by.andersen.intensive.yellow.team.dao.sql.connection.factory;

import java.util.Properties;

import by.andersen.intensive.yellow.team.dao.sql.connection.constant.ConnectionConstant;

public class ConnectionPropertiesFactory {
	
    private static final String USER_PROPERTY = "user";
    
    private static final String PASSWORD_PROPERTY = "password";
    
    private static final String AUTO_RECONNECT_PROPERTY = "autoReconnect";
    
    private static final String CHARACTER_ENCODING_PROPERTY = "characterEncoding";
    
    private static final String UNICODE_PROPERTY = "useUnicode";
    
    private ConnectionPropertiesFactory() {
    	super();
    }
	
	public static Properties newInstance() {
		Properties properties = new Properties();
		properties.put(USER_PROPERTY, ConnectionConstant.DATABASE_USER_BUNDLE_KEY);
		properties.put(PASSWORD_PROPERTY, ConnectionConstant.DATABASE_PASSWORD_BUNDLE_KEY);
		properties.put(AUTO_RECONNECT_PROPERTY, ConnectionConstant.DATABASE_AUTO_RECONNECT_BUNDLE_KEY);
		properties.put(CHARACTER_ENCODING_PROPERTY, ConnectionConstant.DATABASE_CHARACTER_ENCODING_BUNDLE_KEY);
		properties.put(UNICODE_PROPERTY, ConnectionConstant.DATABASE_UNICODE_BUNDLE_KEY);
		return properties;
	}

}
