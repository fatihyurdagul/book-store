package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    List<OrderEntity> findOrderEntityByCustomerId(String customerId);

    Optional<OrderEntity> findOrderEntityById(String orderId);

    List<OrderEntity> findOrderEntityByCreatedDateBetween(Date from, Date to);
}
