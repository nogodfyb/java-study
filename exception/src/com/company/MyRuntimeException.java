package com.company;

public class MyRuntimeException extends RuntimeException {

    public MyRuntimeException() {
    }

    public MyRuntimeException(String message) {
        super(message);
    }
}
