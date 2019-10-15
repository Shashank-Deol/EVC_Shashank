package com.tricon.evc.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends Exception {


    private static final long serialVersionUID = 1L;

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> somethingWentWrong(Exception e) {
        ErrorMessage exceptionResponse = new ErrorMessage(e.getMessage(), "What else do you want to add ?");
        return (new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }
}
