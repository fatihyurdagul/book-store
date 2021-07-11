package com.bookstore.restapi.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StatisticDto extends BaseDto {
    private String month;
    private Integer totalOrder;
    private BigDecimal totalAmount;
    private Integer purchasedBookCount;
}
