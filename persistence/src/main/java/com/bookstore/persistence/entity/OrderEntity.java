package com.bookstore.persistence.entity;

import com.bookstore.enums.OrderStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String id;
    private String customerId;
    private List<BookEntity> books;
    private OrderStatus status;
    private BigDecimal amount;
}
