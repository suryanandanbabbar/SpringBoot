package com.demo.springBootCRUD.Exception;

import com.demo.springBootCRUD.Response.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseStructure<String>> handle2() {
        ResponseStructure<String> res = new ResponseStructure<>();
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());
        res.setMessage("Cannot invoke length method from null");
        res.setData("Name is null");

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
