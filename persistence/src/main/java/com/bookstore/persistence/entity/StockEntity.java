package com.bookstore.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "stocks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {
    @Id
    private String id;
    private Long bookId;
    private Integer stock;
}
