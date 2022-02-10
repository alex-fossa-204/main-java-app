package by.andersen.intensive.bakulin.service.exception;

public class ServiceException extends Exception{

	private static final long serialVersionUID = 2857287312919095986L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(Exception exception) {
		super(exception);
	}

	public ServiceException(String message) {
		super(message);
	}
	
}
