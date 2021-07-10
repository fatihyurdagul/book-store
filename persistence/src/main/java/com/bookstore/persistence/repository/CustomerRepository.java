package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity,Long> {
}
