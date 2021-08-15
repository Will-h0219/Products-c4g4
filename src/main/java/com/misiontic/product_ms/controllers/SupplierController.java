package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.exceptions.suppliers.SupplierAlreadyExistsException;
import com.misiontic.product_ms.models.Supplier;
import com.misiontic.product_ms.repositories.SupplierRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @PostMapping("/suppliers")
    Supplier newSupplier(@RequestBody Supplier supplier) {
        Supplier refSupplier = supplierRepository.findById(supplier.getSupplierId()).orElse(null);

        if (refSupplier != null) {
            throw new SupplierAlreadyExistsException(String.format("El proveedor %s, con id %s ya se encuentra creado", supplier.getSupplierName(), supplier.getSupplierId()));
        }

        return supplierRepository.save(supplier);
    }
}
