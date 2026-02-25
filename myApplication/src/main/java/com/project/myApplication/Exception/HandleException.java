package com.project.myApplication.Exception;

import com.project.myApplication.DTO.Client;
import com.project.myApplication.Response.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(IDNotFoundException e) {
        ResponseStructure<String> res = new ResponseStructure<>();

        res.setStatusCode(HttpStatus.NOT_FOUND.value());
        res.setMessage("Give existing ID");
        res.setData(e.getMessage());

        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
