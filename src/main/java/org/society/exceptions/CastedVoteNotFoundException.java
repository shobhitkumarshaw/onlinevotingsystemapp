package org.society.exceptions;

public class CastedVoteNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;


	private String operation;

	public CastedVoteNotFoundException(String operation,String message) {
		super(message);
		this.operation = operation;
		
	}
	
	public String getOperation() {
		return operation;
	}

}
