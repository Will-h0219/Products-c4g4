package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

public class Product {
    @Id
    private String productId;

    private String userId;
    private String productName;
    private String category;
    private String imgUrl;
    private Double minimumAmount;
    private ArrayList<String> suppliersId;
    private Date lastChange;

    public Product(String productId, String userId, String productName, String category, String imgUrl, Double minimumAmount, ArrayList<String> suppliersId, Date lastChange) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.category = category;
        this.imgUrl = imgUrl;
        this.minimumAmount = minimumAmount;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Double minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public ArrayList<String> getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(ArrayList<String> suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
