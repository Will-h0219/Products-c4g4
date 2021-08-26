package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.exceptions.products.ProductAlreadyExistsException;
import com.misiontic.product_ms.exceptions.products.ProductNotFoundException;
import com.misiontic.product_ms.exceptions.suppliers.SupplierNotFoundException;
import com.misiontic.product_ms.models.PagedList;
import com.misiontic.product_ms.models.PagingParameters;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.ProductRepository;
import com.misiontic.product_ms.repositories.SupplierRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.*;

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

    @GetMapping("/all-products/{userId}")
    List getAllProducts(@PathVariable String userId) {

        return productRepository.findByUserIdOrderByProductId(userId);
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product) {
        Product refProduct = productRepository.findById(product.getProductId()).orElse(null);
        var supExists = false;
        for (String supId : product.getSuppliersId()) {
            supExists = supplierRepository.existsById(supId);
        }

        if (refProduct != null) {
            throw new ProductAlreadyExistsException(String.format("Error al crear el producto %s, utilice otro id", product.getProductId()));
        }
        if (!supExists) {
            throw new SupplierNotFoundException("El proveedor no se ecuentra registrado");
        }
        var upperName = product.getProductName().toUpperCase();
        product.setProductName(upperName);
        product.setLastChange(new Date());

        return productRepository.save(product);
    }

    @PostMapping("/my-products")
    PagedList myProducts(@RequestBody PagingParameters pagingParameters) {
        if (pagingParameters.getUserId() == null) {
            throw new ProductNotFoundException("Error con userId");
        }
        ArrayList<Product> products;
        if (pagingParameters.getSearchParam() != null) {
            products = productRepository.findByUserIdAndProductNameRegexOrderByProductId(pagingParameters.getUserId(), pagingParameters.getSearchParam().toUpperCase())
                    .stream().skip((pagingParameters.getPageNumber() - 1) * pagingParameters.getPageSize())
                    .limit(pagingParameters.getPageSize())
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            products = productRepository.findByUserIdOrderByProductId(pagingParameters.getUserId())
                    .stream().skip((pagingParameters.getPageNumber() - 1) * pagingParameters.getPageSize())
                    .limit(pagingParameters.getPageSize())
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        Long count = productRepository.countByUserId(pagingParameters.getUserId());
        return new PagedList(products, count, pagingParameters.getPageNumber(), pagingParameters.getPageSize());
    }

    @PutMapping("/modify-product/{productId}")
    String modifyProduct(@PathVariable("productId")String productId, @RequestBody Product product){
        productRepository.deleteById(productId);
        product.setLastChange(new Date());
        productRepository.save(product);
        return "Se han modificado los datos del producto "+product.getProductId();
    }

    @DeleteMapping("/delete-product/{productId}")
    String deleteProduct(@PathVariable("productId") String productId) {
        productRepository.deleteById(productId);
        return "producto eliminado";
    }
}
