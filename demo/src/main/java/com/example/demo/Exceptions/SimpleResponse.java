package com.example.demo.Exceptions;


//Later if we want to change the message structure, we come here and add more fields to the object
public class SimpleResponse {

    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
