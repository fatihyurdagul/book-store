package com.bookstore.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
}
