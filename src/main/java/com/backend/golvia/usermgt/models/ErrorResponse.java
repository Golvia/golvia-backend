package com.backend.golvia.usermgt.models;

import java.time.LocalDateTime;

public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
    private Object details;

    public ErrorResponse(int status, String message, LocalDateTime timestamp, Object details) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    // Getters and setters...
}

