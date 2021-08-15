package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.exceptions.products.ProductAlreadyExistsException;
import com.misiontic.product_ms.exceptions.products.ProductNotFoundException;
import com.misiontic.product_ms.exceptions.suppliers.SupplierNotFoundAdvice;
import com.misiontic.product_ms.exceptions.suppliers.SupplierNotFoundException;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.ProductRepository;
import com.misiontic.product_ms.repositories.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductController(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/products/{productId}")
    Product getProduct(@PathVariable String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(String.format("No se encontro el producto con id %s", productId)));
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product) {
        Product refProduct = productRepository.findById(product.getProductId()).orElse(null);
        Boolean supExists = false;
        for (String supId : product.getSuppliersId()) {
            supExists = supplierRepository.existsById(supId) ? true : false;
        }

        if (refProduct != null) {
            throw new ProductAlreadyExistsException(String.format("No se puede crear el producto, el id %s ya se encuentra en uso", product.getProductId()));
        }
        if (!supExists) {
            throw new SupplierNotFoundException("El proveedor no existe");
        }

        return productRepository.save(product);
    }
}
