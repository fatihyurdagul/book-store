package com.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDomain extends BaseDomain {
    private String title;
    private String author;
    private String shortDesc;
    private BigDecimal price;
}
