package com.joenpaco.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioEmailException extends RuntimeException {

	public UsuarioEmailException(String message) {
		super(message);
	}
	
	

}
