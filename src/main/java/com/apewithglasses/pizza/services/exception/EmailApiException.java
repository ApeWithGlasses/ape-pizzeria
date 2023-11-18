package com.apewithglasses.pizza.services.exception;

public class EmailApiException extends RuntimeException {
    public EmailApiException() {
        super("Error sending email...");
    }
}
