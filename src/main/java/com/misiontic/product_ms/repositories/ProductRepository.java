package com.misiontic.product_ms.repositories;

import com.misiontic.product_ms.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    ArrayList<Product> findByUserIdOrderByProductId(String userId);
    ArrayList<Product> findByUserIdAndProductNameRegexOrderByProductId(String userId, String productName);
    ArrayList<Product> findByUserIdAndCategoryOrderByProductId(String userId, String category);
    Long countByUserId(String userId);
}