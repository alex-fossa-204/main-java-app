package by.andersen.intensive.bakulin.dao.connection.sql.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

import by.andersen.intensive.bakulin.dao.connection.sql.constant.ConnectionConstant;
import by.andersen.intensive.bakulin.dao.connection.sql.factory.ConnectionFactory;

public class ConnectionPool {
	
    private static Lock poolInstanceLocker;
    
    private static Condition poolInstanceCondition;
    
    private static AtomicBoolean poolAtomicBoolean;
    
    private static ConnectionPool connectionPoolInstance;
    
    private static final String COULD_NOT_RECEIVE_CONNECTION_EXCEPTION_MESSAGE = "Could not receive connection";

    private static final String COULD_CLOSE_CONNECTION_POOL_EXCEPTION_MESSAGE = "Could not close connection pool";
    
    private final LinkedList<Connection> connectionQueue;
    
        
    private ConnectionPool() {
    	connectionQueue = connectionQueueInitializer();
    	poolInstanceLocker = new ReentrantLock();
    	poolInstanceCondition = poolInstanceLocker.newCondition();
    	poolAtomicBoolean = new AtomicBoolean(true);
    }
    
    public static ConnectionPool getInstance() {
    	boolean isBooleanInstanceAvailable = poolAtomicBoolean.get();
    	if(isBooleanInstanceAvailable) {
    		poolInstanceLocker.lock();
    		setPoolInstance();
    	}
    	return connectionPoolInstance;
    }
    
    public Connection getConnection() {
    	Connection connection = null;
    	poolInstanceLocker.lock();
    	try {
    		if(connectionQueue.isEmpty()) {
    			poolInstanceCondition.await();
    		}
    		connection = connectionQueue.poll();
    	} catch (InterruptedException interruptedException) {
			throw new IllegalStateException(COULD_NOT_RECEIVE_CONNECTION_EXCEPTION_MESSAGE);
		} finally {
			poolInstanceLocker.unlock();
		}
    	return connection;
    }
    
    public void putConnection(Connection connection) {
    	poolInstanceLocker.lock();
    	try {
			connectionQueue.addLast(connection);
			poolInstanceCondition.signal();
		} finally {
			poolInstanceLocker.unlock();
		}
    }
    
    public void closePool() {
    	connectionQueue.stream().forEach(e -> {
			try {
				e.close();
			} catch (SQLException e1) {
				throw new IllegalStateException(COULD_CLOSE_CONNECTION_POOL_EXCEPTION_MESSAGE);
			}
		});
	}
    
    private static void setPoolInstance() {
    	try {
        	boolean isPoolInstanceNull = isPoolInstanceNull();
        	if(isPoolInstanceNull) {
        		connectionPoolInstance = new ConnectionPool();
        		poolAtomicBoolean.set(false);
        	}
    	} finally {
    		poolInstanceLocker.unlock();
		}
    }
    
    private static boolean isPoolInstanceNull() {
    	Predicate<ConnectionPool> isNull = e -> e == null;
    	return isNull.test(connectionPoolInstance);
    }
    
	private LinkedList<Connection> connectionQueueInitializer() {
		LinkedList<Connection> connectionQueue = new LinkedList<Connection>();
		int connectionQueueSize = Integer.parseInt(ConnectionConstant.CONNECTION_POOL_QUEUE_SIZE_BUNDLE_KEY);
		
		for(int queueIndex = 0; queueIndex < connectionQueueSize; queueIndex++) {
			connectionQueue.add(ConnectionFactory.newInstance());
		}
		
		return connectionQueue;
	}
	
	

}
