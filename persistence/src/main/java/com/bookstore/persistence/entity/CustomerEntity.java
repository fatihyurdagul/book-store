package com.bookstore.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String encryptedPassword;
    private String name;
    private String surname;
}
