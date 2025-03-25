package com.app.myntra.exception;


public class CustomException extends RuntimeException {
    private final int code;

    public CustomException(int code, String message) {
        super(message); // Use the built-in message handling
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
