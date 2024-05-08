package com.uibs.bank.registration_module.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	private int statusCode;
	private String message;
	private HttpStatus statusMessage;
	private String UrlPath;
	private Date date;
}
