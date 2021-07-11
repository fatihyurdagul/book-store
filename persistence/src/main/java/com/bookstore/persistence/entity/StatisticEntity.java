package com.bookstore.persistence.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticEntity {
    private String month;
    private String customerId;
    private Integer totalOrder;
    private BigDecimal totalAmount;
    private Integer totalBookCount;
}
