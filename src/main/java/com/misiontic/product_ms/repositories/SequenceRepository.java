package com.misiontic.product_ms.repositories;

import com.misiontic.product_ms.models.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends MongoRepository<DatabaseSequence, String> {
}
