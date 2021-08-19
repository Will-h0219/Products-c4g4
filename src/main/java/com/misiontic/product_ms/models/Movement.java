package com.misiontic.product_ms.models;

import java.util.Date;

public class Movement {
    private String productId;
    private String kindOfMovement;// venta-compra o entrada-salida
    private Integer quantity;
    private Double cost;
    private Date date;

    public Movement(String productId, String kindOfMovement, Integer quantity, Double cost, Date date) {
        this.productId = productId;
        this.kindOfMovement = kindOfMovement;
        this.quantity = quantity;
        this.cost = cost;
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getKindOfMovement() {
        return kindOfMovement;
    }

    public void setKindOfMovement(String kindOfMovement) {
        this.kindOfMovement = kindOfMovement;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
