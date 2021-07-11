package com.bookstore.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDomain extends BaseDomain {
    private String bookId;
    private Integer stock;
}
