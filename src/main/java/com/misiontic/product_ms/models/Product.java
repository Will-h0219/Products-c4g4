package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
    @Id
    private String productId;

    private String userId;
    private String productName;
    private ArrayList<String> suppliersId;
    private ArrayList<Movement> movements;
    private Date lastChange;

    public Product(String productId, String userId, String productName, ArrayList<String> suppliersId, ArrayList<Movement> movements, Date lastChange) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.suppliersId = suppliersId;
        this.movements = movements;
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

    public ArrayList<String> getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(ArrayList<String> suppliersId) {
        this.suppliersId = suppliersId;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public void addMovements(Movement movement) {
        this.movements.add(movement);
    }
}
