package com.demo.springBootCRUD.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(NullPointerException.class)
    public void handle1() {
        System.out.println("Exception handled");
    }
}
