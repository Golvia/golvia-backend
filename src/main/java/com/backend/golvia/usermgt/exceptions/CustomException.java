package com.backend.golvia.usermgt.exceptions;



public class CustomException extends RuntimeException {
    private final int status;
    private int code;
    private Throwable cause;
    private String message;

    public CustomException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public CustomException(int status, String message, Throwable cause, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.cause = cause;
    }

    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
