package com.sedef.notes.config;

import lombok.Data;

@Data
public class ErrorResponse {
    private int statusCode;
    private String message;
    // Getter methods
}