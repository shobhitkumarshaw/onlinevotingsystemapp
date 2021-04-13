package org.society.exceptions;

public class VoterNotFoundException extends RuntimeException{
	public VoterNotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
