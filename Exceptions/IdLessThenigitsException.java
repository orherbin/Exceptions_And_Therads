package com.company;

public class IdLessThenigitsException extends Exception {
    public IdLessThenigitsException() {
    }

    public IdLessThenigitsException(String student) {
        super(student);
    }
}
