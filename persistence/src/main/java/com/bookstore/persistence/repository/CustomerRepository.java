package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity,Long> {

    Optional<CustomerEntity> findCustomerEntityByUsername(String username);
}
