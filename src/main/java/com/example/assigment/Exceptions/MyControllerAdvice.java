package com.example.assigment.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(value = {IOException.class, SecurityException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void handleException2() {}
    @ExceptionHandler(value = {BadRequestException.class, FileAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleException1() {}
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleException() {}
}
