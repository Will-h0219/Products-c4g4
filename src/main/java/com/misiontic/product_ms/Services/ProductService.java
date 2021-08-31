package com.misiontic.product_ms.Services;

import com.misiontic.product_ms.Services.Contracts.IProductService;
import com.misiontic.product_ms.exceptions.products.ProductAlreadyExistsException;
import com.misiontic.product_ms.exceptions.suppliers.SupplierNotFoundException;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.ProductRepository;
import com.misiontic.product_ms.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public Product createProduct(Product product) {
        Product refProduct = productRepository.findById(product.getProductId()).orElse(null);
        var supExists = false;
        for (String supId : product.getSuppliersId()) {
            supExists = supplierRepository.existsById(supId);
        }

        if (refProduct != null) {
            throw new ProductAlreadyExistsException(String.format("El producto con id %s ya se encuentra creado", product.getProductId()));
        }
        if (!supExists) {
            throw new SupplierNotFoundException("El proveedor no se encuentra registrado.");
        }
        var upperName = product.getProductName().toUpperCase();
        product.setProductName(upperName);
        product.setLastChange(new Date());

        return productRepository.save(product);
    }

    public Product modifyProduct(Product product) {
        var supExists = false;
        for (String supId : product.getSuppliersId()) {
            supExists = supplierRepository.existsById(supId);
        }
        if (!supExists) {
            throw new SupplierNotFoundException("El proveedor que intenta registrar no se encuentra creado.");
        }
        product.setLastChange(new Date());
        return productRepository.save(product);
    }
}
