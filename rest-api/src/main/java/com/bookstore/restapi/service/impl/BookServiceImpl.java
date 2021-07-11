package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.restapi.domain.BookDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;
import com.bookstore.restapi.mapper.BookDtoMapper;
import com.bookstore.restapi.service.BookService;
import com.bookstore.restapi.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookAdapter bookAdapter;
    private final StockService stockService;
    private final BookDtoMapper mapper;

    @Override
    public Boolean createBook(BookDto request) {
        BookDomain bookDomain = mapper.toDomainObject(request);
        BookDomain result = bookAdapter.saveBook(bookDomain);
        // TODO : get stock info from request
        UpdateStockRequestDto updateStock = UpdateStockRequestDto.builder()
                .bookId(result.getId())
                .stock(0)
                .build();

        return stockService.updateBookOfStock(updateStock);
    }

    @Override
    public List<BookDto> getAllBook() {
        return bookAdapter.getAllBook().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
