package org.example.techie.exceptionhandlingspringbootdemo.exception;

public class categoryNotFoundException extends Exception{

    public categoryNotFoundException(String message) {
        super(message);
    }
}
