package org.society.exceptions;

public class DuplicateEntityFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String operation;

	public DuplicateEntityFoundException(String operation,String message) {
		super(message);
		this.operation = operation;
		
	}
	public DuplicateEntityFoundException(String message) {
		super(message);
		
	}
	
	
	public String getMessage() {
		return operation;
	}
}
