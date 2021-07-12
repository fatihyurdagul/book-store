package com.bookstore.restapi.controller;

import com.bookstore.restapi.domain.StockDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;
import com.bookstore.restapi.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDto>> getAllStock(){
        return ResponseEntity.ok(stockService.getAllStock());
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<StockDto> updateStockOfBook(@RequestBody Integer stock, @PathVariable String bookId) {
        UpdateStockRequestDto request = UpdateStockRequestDto.builder()
                .stock(stock)
                .bookId(bookId)
                .build();
        return ResponseEntity.ok(stockService.updateBookOfStock(request));
    }
}
