package com.bookstore.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Statistic {
    private String month;
    private Long customerId;
    private Integer totalOrder;
    private BigDecimal totalAmount;
    private Integer totalBookCount;
}
