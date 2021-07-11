package com.bookstore.restapi.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDto {
    private String customerId;
    private List<BookOrderDto> items;
}
