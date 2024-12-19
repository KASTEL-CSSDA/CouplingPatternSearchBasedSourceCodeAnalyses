package exceptions;

public class CodeSaveException extends Exception {

	/**
	 * An exception that is thrown when an error occurs while saving code. This
	 * exception extends the standard Exception class.
	 * 
	 */
	private static final long serialVersionUID = 3789495718893303620L;

	public CodeSaveException(String errorMessage) {
		super(errorMessage);
	}
}
