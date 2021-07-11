package com.bookstore.persistence.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String bookId;
    private Integer stock;
}
