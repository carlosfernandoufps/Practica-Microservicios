package co.pragma.customerservice.exception;

import org.springframework.http.HttpStatus;

public class CustomerException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;

	public CustomerException(HttpStatus httpStatus, String errorMessage) {
		super(errorMessage);
		this.httpStatus = httpStatus;
	}
	
	
}
