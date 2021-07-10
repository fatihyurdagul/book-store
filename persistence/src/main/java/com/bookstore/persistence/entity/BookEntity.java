package com.bookstore.persistence.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

@Document(collection = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    private String id;
    private String title;
    private String author;
    private String shortDesc;
    private BigDecimal price;
}
