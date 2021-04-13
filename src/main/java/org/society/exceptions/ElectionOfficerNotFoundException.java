package org.society.exceptions;

public class ElectionOfficerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private String operation;

	public ElectionOfficerNotFoundException(String operation,String message) {
		super(message);
		this.operation = operation;
		
	}
	
	public String getOperation() {
		return operation;
	}
}
