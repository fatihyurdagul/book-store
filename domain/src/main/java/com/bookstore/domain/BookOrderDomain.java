package com.bookstore.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookOrderDomain{
    private BookDomain book;
    private Integer quantity;
}
