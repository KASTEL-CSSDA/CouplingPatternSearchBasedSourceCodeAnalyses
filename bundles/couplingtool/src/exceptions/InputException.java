package exceptions;

public class InputException extends Exception {

	/**
	 * An exception that is thrown when an error occurs related to the input process. This
	 * exception extends the standard Exception class.
	 * 
	 */
	private static final long serialVersionUID = 3789495718893303620L;

	public InputException(String errorMessage) {
		super(errorMessage);
	}
}
