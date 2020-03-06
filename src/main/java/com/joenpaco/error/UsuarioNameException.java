package com.joenpaco.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioNameException extends RuntimeException {

	public UsuarioNameException(String message) {
		super(message);
	}

	
	
}
