package org.society.exceptions.handler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.society.exceptions.DuplicateEntityFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorList = 
				ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(fe -> fe.getDefaultMessage())
				.collect(Collectors.toList());
		
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("data error", "Problem in data received");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("errors", errorList);
		return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
	
	}
	
//	@ExceptionHandler(DuplicateEmployeeException.class)
//	public ResponseEntity<?> handleDumplicateEntity(DuplicateEmployeeException ex) {
//		log.info("Exception Not able to create Employee object");
//		Map<String, Object> errorBody = new LinkedHashMap<>();
//		errorBody.put("error", "Creation Failed");
//		errorBody.put("timestamp", LocalDateTime.now());
//		errorBody.put("details", ex.getMessage());
//		return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
//		
//		
//
//	}
	
	@ExceptionHandler(DuplicateEntityFoundException.class)
	public ResponseEntity<?> handleDuplicateEntityFoundException(DuplicateEntityFoundException ex){
		
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "creation failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
		return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
	}

}
