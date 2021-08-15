package com.misiontic.product_ms.repositories;

import com.misiontic.product_ms.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
