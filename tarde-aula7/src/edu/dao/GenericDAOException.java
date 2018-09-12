package edu.dao;

public class GenericDAOException extends Exception {
	private static final long serialVersionUID = -6702359385825023257L;

	public GenericDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericDAOException(String message) {
		super(message);
	}

	public GenericDAOException(Throwable cause) {
		super(cause);
	}
}
