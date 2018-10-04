package edu.dao;

public class GenericDAOException extends Exception {
	private static final long serialVersionUID = 8360898015631083132L;

	public GenericDAOException() {
	}

	public GenericDAOException(String arg0) {
		super(arg0);
	}

	public GenericDAOException(Throwable arg0) {
		super(arg0);
	}

	public GenericDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
