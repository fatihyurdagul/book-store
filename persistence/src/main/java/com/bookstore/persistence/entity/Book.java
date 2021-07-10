package com.bookstore.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Book {
    private Long id;
    private String title;
    private String author;
    private String shortDesc;
    private BigDecimal price;
}
