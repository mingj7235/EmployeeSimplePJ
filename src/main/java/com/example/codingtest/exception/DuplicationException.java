package com.example.codingtest.exception;

public class DuplicationException extends RuntimeException{

    public DuplicationException() {
    }

    public DuplicationException(String message) {
        super("해당 직원 번호가 존재합니다. ");
    }

}
