package com.demo.springBootCRUD.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

//  Response in the console
//    @ExceptionHandler(NullPointerException.class)
//    public void handle1() {
//        System.out.println("Exception handled");
//    }

//  Response in Postman
    @ExceptionHandler(NullPointerException.class)
    public void handle1() {
        System.out.println("Exception handled");
    }
}
