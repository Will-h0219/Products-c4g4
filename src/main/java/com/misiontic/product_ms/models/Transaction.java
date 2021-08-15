package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String transactionId;

    private String productIdAffected;
    private String transaction; //venta o compra
    private Integer quantity;
    private Date date;

    public Transaction(String transactionId, String productIdAffected, String transaction, Integer quantity, Date date) {
        this.transactionId = transactionId;
        this.productIdAffected = productIdAffected;
        this.transaction = transaction;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductIdAffected() {
        return productIdAffected;
    }

    public void setProductIdAffected(String productIdAffected) {
        this.productIdAffected = productIdAffected;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
