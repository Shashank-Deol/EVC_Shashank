package com.tricon.evc.exceptionhandler;

public class ErrorMessage {


    private String message;
    private String details;


    public ErrorMessage(final String message, final String details) {
        super();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}