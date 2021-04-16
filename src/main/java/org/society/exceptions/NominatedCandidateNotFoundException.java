/*
 * Author- Govind Kidambi
 */

package org.society.exceptions;

public class NominatedCandidateNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public NominatedCandidateNotFoundException(String msg) {
		super(msg);
	}
}
