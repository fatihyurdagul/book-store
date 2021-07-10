package com.bookstore.persistence.entity;

import com.bookstore.persistence.enums.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class OrderEntity {
    @Id
    private Long id;
    private Long customerId;
    private List<BookEntity> books;
    private OrderStatus status;
}
