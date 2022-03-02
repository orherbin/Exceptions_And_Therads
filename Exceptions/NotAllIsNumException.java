package com.company;

public class NotAllIsNumException extends Exception {
    public NotAllIsNumException() {
    }

    public NotAllIsNumException(String student) {
        super(student);
    }
}
