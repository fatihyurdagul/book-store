package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.StockDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;

import java.util.List;

public interface StockService {
    Boolean updateBookOfStock(UpdateStockRequestDto request);

    List<StockDto> getAllStock();
}
