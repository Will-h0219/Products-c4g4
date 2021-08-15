package com.misiontic.product_ms.exceptions.suppliers;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(String message) {
        super(message);
    }
}
