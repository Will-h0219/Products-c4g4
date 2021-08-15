package com.misiontic.product_ms.exceptions.transactions;

public class InsufficientProductsException extends RuntimeException{
    public InsufficientProductsException(String message) {
        super(message);
    }
}
