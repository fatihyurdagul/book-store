package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.StockEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<StockEntity, String> {
}
