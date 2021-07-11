package com.bookstore.domain;

import com.bookstore.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderDomain extends BaseDomain {
    private String customerId;
    private List<BookOrderDomain> items;
    private OrderStatus status;
    private BigDecimal amount;
}
