package org.society.exceptions.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.exceptions.ElectionResultNotFoundException;
import org.society.exceptions.EmptyDataException;
import org.society.exceptions.NoAdminFoundException;
import org.society.exceptions.NoUserLoggedInException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.exceptions.SocietyNotFoundException;
import org.society.exceptions.UserNotFoundException;
import org.society.exceptions.VoteAllReadyCastedException;
import org.society.exceptions.VoterNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorList = ex.getBindingResult().getFieldErrors().stream().map(fe -> fe.getDefaultMessage())
				.collect(Collectors.toList());

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("dataerror", "Problem in data received");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("errors", errorList);
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(DuplicateEntityFoundException.class)
	public ResponseEntity<?> handleDuplicateEntityFoundException(DuplicateEntityFoundException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "creation failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ElectionResultNotFoundException.class)
	public ResponseEntity<?> handleElectionResultNotFound(ElectionResultNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error"," Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ElectionOfficerNotFoundException.class)
	public ResponseEntity<?> handleElectionOfficerNotFound(ElectionOfficerNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error"," Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoAdminFoundException.class)
	public ResponseEntity<?> handleNoAdminFound(NoAdminFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error"," Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CastedVoteNotFoundException.class)
	public ResponseEntity<?> handleCastedVoteNot(CastedVoteNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<?> handleEmptyData(EmptyDataException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error"," Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);  
	}
	
	@ExceptionHandler(NominatedCandidateNotFoundException.class)
	public ResponseEntity<?> handleNominatedCandidateNotFound(NominatedCandidateNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SocietyNotFoundException.class)
	public ResponseEntity<?> handleSocietyNotFound(SocietyNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(VoteAllReadyCastedException.class)
	public ResponseEntity<?> handleVoteAllReadyCasted(VoteAllReadyCastedException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(VoterNotFoundException.class)
	public ResponseEntity<?> handleVoterNotFound(VoterNotFoundException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoUserLoggedInException.class)
	public ResponseEntity<?> handleNoUserLoggedInException(NoUserLoggedInException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	
}
