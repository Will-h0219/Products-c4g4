package com.misiontic.product_ms.repositories;

import com.misiontic.product_ms.models.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
}
