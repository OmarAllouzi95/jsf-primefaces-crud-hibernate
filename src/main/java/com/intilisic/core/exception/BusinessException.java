package com.intilisic.core.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(Throwable throwable) {
		super(throwable);
	}

	public BusinessException(String message) {
		super(message);
	}
}
