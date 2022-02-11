package by.andersen.intensive.bakulin.dao.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = -3042529476833365696L;
	
	public DAOException() {
		super();
	}
	
	public DAOException(Exception exception) {
		super(exception);
	}

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Exception exception) {
		super(message, exception);
	}

}
