package com.misiontic.product_ms.models;

import org.springframework.data.annotation.Id;

public class Supplier {
    @Id
    private String supplierId;

    private String userId;
    private String supplierName;
    private String phone;
    private String email;

    public Supplier(String supplierId, String userId, String supplierName, String phone, String email) {
        this.supplierId = supplierId;
        this.userId = userId;
        this.supplierName = supplierName;
        this.phone = phone;
        this.email = email;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
