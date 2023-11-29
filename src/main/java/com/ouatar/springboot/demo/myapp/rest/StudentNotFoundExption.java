package com.ouatar.springboot.demo.myapp.rest;

public class StudentNotFoundExption extends  RuntimeException{


    public StudentNotFoundExption(String message) {
        super(message);
    }

    public StudentNotFoundExption(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundExption(Throwable cause) {
        super(cause);
    }
}
