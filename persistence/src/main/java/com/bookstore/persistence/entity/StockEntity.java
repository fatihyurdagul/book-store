package com.bookstore.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "stocks")
public class StockEntity {
    @Id
    private Long id;
    private Long bookId;
    private Integer stock;
}
