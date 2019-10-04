package com.evc.eventhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UpdatedRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UpdatedRuntimeException(String exception) {
		super(exception);
	}
}
