package com.example.FirstSpringAPI.exceptions;

import com.example.FirstSpringAPI.dtos.ExceptionDto;
import com.example.FirstSpringAPI.dtos.ProductNotFoundExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmaticException(ArithmeticException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("Nothing to do with it");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setMessage(e.getMessage());
        ResponseEntity<ProductNotFoundExceptionDto> prodNotFoundResponse = new ResponseEntity<>(productNotFoundExceptionDto,
                HttpStatus.NOT_FOUND);
        return prodNotFoundResponse;
    }
}
