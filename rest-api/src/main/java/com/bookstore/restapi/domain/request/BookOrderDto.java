package com.bookstore.restapi.domain.request;

import lombok.Data;

@Data
public class BookOrderDto {
    private String bookId;
    private Integer quantity;
}
