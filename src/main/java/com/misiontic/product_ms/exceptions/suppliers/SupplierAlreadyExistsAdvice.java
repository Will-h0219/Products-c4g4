package com.misiontic.product_ms.exceptions.suppliers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class SupplierAlreadyExistsAdvice {
    @ResponseBody
    @ExceptionHandler(SupplierAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String SupplierAlreadyExists(SupplierAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
