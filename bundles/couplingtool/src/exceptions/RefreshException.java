package exceptions;

public class RefreshException extends Exception {

	/**
	 * An exception that is thrown when an error occurs while refreshing model code.
	 * This exception extends the standard Exception class.
	 * 
	 */
	private static final long serialVersionUID = 3789495718893303620L;

	public RefreshException(String errorMessage) {
		super(errorMessage);
	}
}
