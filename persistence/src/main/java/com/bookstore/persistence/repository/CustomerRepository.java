package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Long> {
}
