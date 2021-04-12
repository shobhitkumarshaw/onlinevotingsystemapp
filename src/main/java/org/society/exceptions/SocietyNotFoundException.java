package org.society.exceptions;

public class SocietyNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public SocietyNotFoundException(String message) {
		super(message);
	}
}
