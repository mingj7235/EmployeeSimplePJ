package com.example.codingtest.exception;

public class CannotFindEmplException extends RuntimeException{

    public CannotFindEmplException() {
    }

    public CannotFindEmplException(String message) {
        super("해당 직원을 찾을 수 없습니다. ");
    }

}
