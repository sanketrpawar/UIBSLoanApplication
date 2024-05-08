package com.uibs.bank.registration_module.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.uibs.bank.registration_module.model.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(RegistrationUnsuccessfulException.class)
	public ResponseEntity<ApiResponse> registrationNotDoneExceptionHandler(RegistrationUnsuccessfulException e, HttpServletRequest request){
		
		log.info("exceuting registrationNotDoneExceptionHandler method");
		ApiResponse error = new ApiResponse();
		error.setDate(new Date());
		error.setMessage(e.getMessage());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setUrlPath(request.getRequestURI());
		
		log.info("ApiResponse fields set");
		return new ResponseEntity<ApiResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(LoginCredentialsNotValidException.class)
	public ResponseEntity<ApiResponse> loginCredentialsNotValidExceptionHandler(LoginCredentialsNotValidException e, HttpServletRequest request){
		
		log.info("exceuting loginCredentialsNotValidExceptionHandler method");
		ApiResponse error = new ApiResponse();
		error.setDate(new Date());
		error.setMessage(e.getMessage());
		error.setStatusMessage(HttpStatus.NOT_FOUND);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setUrlPath(request.getRequestURI());
		
		log.info("ApiResponse fields set");
		return new ResponseEntity<ApiResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Map<String,String>> methodNotFoundExceptionHandler(MethodArgumentNotValidException e)
	{
		log.info("executing Validations methodNotFoundExceptionHandler");
		Map<String,String> error=new HashMap<String, String>();
		         List<ObjectError> l=e.getBindingResult().getAllErrors();
		        		              for (ObjectError or : l) {
		        		                              FieldError f=(FieldError)or;
		        		                              error.put(f.getField(),f.getDefaultMessage());
										           }
		  
		
		return new ResponseEntity<Map<String,String>>(error,HttpStatus.BAD_REQUEST);
	}
}
