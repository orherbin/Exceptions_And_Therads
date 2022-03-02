package com.company;

public class FirstCharNoneAlphabeticException extends Exception {
    public FirstCharNoneAlphabeticException() {
    }

    public FirstCharNoneAlphabeticException(String student) {
        super(student);
    }
}
