package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.exceptions.suppliers.SupplierAlreadyExistsException;
import com.misiontic.product_ms.exceptions.suppliers.SupplierNotFoundException;
import com.misiontic.product_ms.models.Supplier;
import com.misiontic.product_ms.repositories.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {

        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/suppliers/{supplierId}")
    Supplier getSupplier(@PathVariable String supplierId){
        return supplierRepository.findById(supplierId)
                .orElseThrow(()->new SupplierNotFoundException(String.format("No se encontro el proveedor con id",supplierId)));
    }

    @GetMapping("/all-suppliers/{userId}")
    List getAllSuppliers(@PathVariable String userId){
        return supplierRepository.findByUserIdOrderBySupplierId(userId);
    }

    @PostMapping("/suppliers")
    Supplier newSupplier(@RequestBody Supplier supplier) {
        Supplier refSupplier = supplierRepository.findById(supplier.getSupplierId()).orElse(null);

        if (refSupplier != null) {
            throw new SupplierAlreadyExistsException(String.format("El proveedor %s, con id %s ya se encuentra creado", supplier.getSupplierName(), supplier.getSupplierId()));
        }

        return supplierRepository.save(supplier);
    }

    @PutMapping("/modify-supplier/{supplierId}")
    String modifySupplier(@PathVariable("supplierId")String supplierId,@RequestBody Supplier supplier){
        supplierRepository.deleteById(supplierId);
        supplierRepository.save(supplier);
        return "Datos del proveedor "+ supplier.getSupplierName()+" actualizados";
    }

    @DeleteMapping("/delete-supplier/{supplierId}")
    String deleteSupplier(@PathVariable("supplierId")String supplierId){
        supplierRepository.deleteById(supplierId);
        return "Proveedor eliminado";
    }
}
