package com.bookstore.persistence.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private String author;
    private String shortDesc;
    private BigDecimal price;
}
