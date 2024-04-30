package com.example.FirstSpringAPI.exceptions;

import com.example.FirstSpringAPI.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message){
         super(message);
    }
}
