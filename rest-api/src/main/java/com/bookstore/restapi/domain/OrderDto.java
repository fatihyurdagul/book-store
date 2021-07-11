package com.bookstore.restapi.domain;

import com.bookstore.enums.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto extends BaseDto {
    private String customerId;
    private List<BookDto> items;
    private OrderStatus status;
}
