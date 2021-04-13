package org.society.exceptions;

public class ElectionResultNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String operation;

	public ElectionResultNotFoundException(String operation,String message) {
		super(message);
		this.operation = operation;
		
	}
	
	public String getOperation() {
		return operation;
	}
}
