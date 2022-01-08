package model.dao;

public class DataAcessException extends RuntimeException {

	private static final long serialVersionUID = -8385409037578094562L;

	public DataAcessException(String message) {
		super(message);
	}

	public DataAcessException(Throwable cause) {
		super(cause);
	}

	public DataAcessException(String message, Throwable cause) {
		super(message, cause);
	}

}
