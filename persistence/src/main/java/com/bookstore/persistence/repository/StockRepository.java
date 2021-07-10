package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, Long> {
}
