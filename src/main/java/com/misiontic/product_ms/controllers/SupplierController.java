package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.Services.Contracts.ISequenceGeneratorService;
import com.misiontic.product_ms.Services.SequenceGeneratorService;
import com.misiontic.product_ms.exceptions.suppliers.SupplierNotFoundException;
import com.misiontic.product_ms.models.Supplier;
import com.misiontic.product_ms.repositories.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    private final SupplierRepository supplierRepository;
    private final ISequenceGeneratorService sequenceGenerator;

    public SupplierController(SupplierRepository supplierRepository, ISequenceGeneratorService sequenceGenerator) {
        this.supplierRepository = supplierRepository;
        this.sequenceGenerator = sequenceGenerator;
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
        if (supplier.getUserId() == null) {
            throw new SupplierNotFoundException("El proveedor debe tener un usuario relacionado");
        }
        long id = sequenceGenerator.generateSequence(supplier.SEQUENCE_NAME);
        supplier.setSupplierId(String.valueOf(id));

        return supplierRepository.save(supplier);
    }

    @PutMapping("/modify-supplier")
    String modifySupplier(@RequestBody Supplier supplier){
        supplierRepository.save(supplier);
        return "Datos del proveedor "+ supplier.getSupplierName()+" actualizados";
    }

    @DeleteMapping("/delete-supplier/{supplierId}")
    String deleteSupplier(@PathVariable("supplierId")String supplierId){
        supplierRepository.deleteById(supplierId);
        return "Proveedor eliminado";
    }
}
