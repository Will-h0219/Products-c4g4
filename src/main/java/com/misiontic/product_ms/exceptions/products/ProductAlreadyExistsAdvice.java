package com.misiontic.product_ms.exceptions.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class ProductAlreadyExistsAdvice {
    @ResponseBody
    @ExceptionHandler(ProductAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String ProductAlreadyExistsAdvice(ProductAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
