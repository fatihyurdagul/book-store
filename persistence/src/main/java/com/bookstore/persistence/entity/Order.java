package com.bookstore.persistence.entity;

import com.bookstore.persistence.enums.OrderStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Order {
    private Long id;
    private Long customerId;
    private List<Book> books;
    private OrderStatus status;
}
