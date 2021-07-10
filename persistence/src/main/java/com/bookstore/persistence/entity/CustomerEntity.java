package com.bookstore.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
}
