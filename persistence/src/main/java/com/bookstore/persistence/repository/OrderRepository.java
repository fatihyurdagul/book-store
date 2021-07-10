package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
}
