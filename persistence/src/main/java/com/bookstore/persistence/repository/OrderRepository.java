package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    List<OrderEntity> findOrderEntityByCustomerId(String customerId);

    Optional<OrderEntity> findOrderEntityById(String orderId);

    Page<OrderEntity> findOrderEntityByCreatedDateBetween(LocalDate from, LocalDate to, Pageable pageable);
}
