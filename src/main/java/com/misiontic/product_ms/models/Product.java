package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Product {
    @Id
    private String productId;

    private String userId;
    private String productName;
    private Float cost;
    private Integer quantityAvailable;
    private List<String> suppliersId;
    private Date lastChange;

    public Product(String productId, String userId, String productName, Float cost, Integer quantityAvailable, List<String> suppliersId, Date lastChange) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.cost = cost;
        this.quantityAvailable = quantityAvailable;
        this.suppliersId = suppliersId;
        this.lastChange = lastChange;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public List<String> getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(List<String> suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
