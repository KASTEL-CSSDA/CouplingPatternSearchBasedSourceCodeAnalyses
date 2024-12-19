package exceptions;

public class ModelSaveException extends Exception {

	/**
	 * An exception that is thrown when an error occurs while saving model code. This
	 * exception extends the standard Exception class.
	 * 
	 */
	private static final long serialVersionUID = 3789495718893303620L;

	public ModelSaveException(String errorMessage) {
		super(errorMessage);
	}
}
