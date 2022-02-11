package by.andersen.intensive.bakulin.dao.connection.sql.constant;

public enum PropertiesConstant {
	
	DATABASE_USER_PROPERTY("database.user"),
	
	DATABASE_PASSWORD_PROPERTY("database.password"), 
	
	CONNECTION_POOL_QUEUE_SIZE_PROPERTY("database.poolSize"),
	
	DATABASE_URL_PROPERTY("database.url"),
	
	DATABASE_AUTO_RECONNECT_PROPERTY("database.autoReconnect"),
	
	DATABASE_CHARACTER_ENCODING_PROPERTY("database.encoding"),
	
	DATABASE_UNICODE_PROPERTY("database.useUnicode");
	
	
	;
	
	private String propertyKey;
	
	PropertiesConstant(String propertyKey) {
		this.propertyKey = propertyKey;
	}
	
	public String getPropertyKey() {
		return this.propertyKey;
	}
	
}
