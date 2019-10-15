package com.tricon.evc.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UpdatedRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * @param exception is the exception value .
     */
    public UpdatedRuntimeException(String exception) {
        super(exception);
    }

    public UpdatedRuntimeException(String exception, Throwable exceptioncause) {
        super(exception, exceptioncause);
    }
}
