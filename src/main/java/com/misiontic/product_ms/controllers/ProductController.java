package com.misiontic.product_ms.controllers;

import com.misiontic.product_ms.Services.Contracts.IProductService;
import com.misiontic.product_ms.Services.Contracts.IPaginationService;
import com.misiontic.product_ms.exceptions.products.ProductNotFoundException;
import com.misiontic.product_ms.models.PagedList;
import com.misiontic.product_ms.models.PagingParameters;
import com.misiontic.product_ms.models.Product;
import com.misiontic.product_ms.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final IProductService productService;
    private final IPaginationService paginationService;

    public ProductController(ProductRepository productRepository,
                             IProductService productService,
                             IPaginationService paginationService) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.paginationService = paginationService;
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
        return productService.createProduct(product);
    }

    @PostMapping("/my-products")
    PagedList myProducts(@RequestBody PagingParameters pagingParameters) {
        return paginationService.getPagination(pagingParameters);
    }

    @PutMapping("/modify-product")
    Product modifyProduct(@RequestBody Product product){
        return productService.modifyProduct(product);
    }

    @DeleteMapping("/delete-product/{productId}")
    String deleteProduct(@PathVariable("productId") String productId) {
        productRepository.deleteById(productId);
        return "producto eliminado";
    }
}
