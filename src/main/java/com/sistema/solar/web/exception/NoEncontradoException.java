package com.sistema.solar.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoEncontradoException(String message) {
		super(message);
	}
}
