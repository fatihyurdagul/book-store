package com.bookstore.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "statistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticEntity {
    private String month;
    private Long customerId;
    private Integer totalOrder;
    private BigDecimal totalAmount;
    private Integer totalBookCount;
}
