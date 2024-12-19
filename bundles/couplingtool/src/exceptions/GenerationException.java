package exceptions;

public class GenerationException extends Exception {

	/**
	 * An exception that is thrown when an error occurs while generating code. This
	 * exception extends the standard Exception class.
	 * 
	 */
	private static final long serialVersionUID = 3789495718893303620L;

	public GenerationException(String errorMessage) {
		super(errorMessage);
	}
}
