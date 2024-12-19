package exceptions;

public class PatternViolationClassException extends Exception {
	/**
	 * An exception that is thrown when a wrong pattern violation name is mapped. This
	 * exception extends the standard Exception class.
	 * 
	 */
	private static final long serialVersionUID = 3789495718893303620L;

	public PatternViolationClassException(String errorMessage) {
		super(errorMessage);
	}

}
