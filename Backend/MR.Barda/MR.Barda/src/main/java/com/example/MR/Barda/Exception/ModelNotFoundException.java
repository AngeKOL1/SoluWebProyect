package com.example.MR.Barda.Exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message);
    }
}