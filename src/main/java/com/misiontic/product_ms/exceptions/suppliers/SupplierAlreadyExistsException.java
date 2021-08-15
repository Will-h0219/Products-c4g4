package com.misiontic.product_ms.exceptions.suppliers;

public class SupplierAlreadyExistsException extends RuntimeException {
    public SupplierAlreadyExistsException(String message) {
        super(message);
    }
}
