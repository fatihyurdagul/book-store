package com.bookstore.adapter;

import com.bookstore.domain.StockDomain;

import java.util.List;

public interface StockAdapter {
    Boolean updateStockOfBook(StockDomain stockOfBook);

    List<StockDomain> getAllBookOfStock();
}
