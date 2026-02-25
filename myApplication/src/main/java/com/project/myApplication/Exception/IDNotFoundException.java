package com.project.myApplication.Exception;

public class IDNotFoundException extends RuntimeException {
    String message = "ID not found";

    public IDNotFoundException(String message) {
        this.message = message;
    }

    public IDNotFoundException() {
        System.out.println("ID not found (from constructor)");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
