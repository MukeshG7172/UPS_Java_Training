package com.example.demo.entity;

import java.util.Map;

public class ErrorResponse {
    private int StatusCode;
    private String Message;
    private Map<String,String> Error;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Map<String, String> getError() {
        return Error;
    }

    public void setError(Map<String, String> error) {
        Error = error;
    }

    public ErrorResponse(int statusCode, String message, Map<String, String> error) {
        StatusCode = statusCode;
        Message = message;
        Error = error;
    }
}
