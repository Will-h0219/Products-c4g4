package com.misiontic.product_ms.repositories;

import com.misiontic.product_ms.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByTransaction(String transaction);
    List<Transaction> findByProductIdAffected(String productIdAffected);
}
