package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.adapter.StockAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.restapi.domain.StockDto;
import com.bookstore.restapi.domain.request.UpdateStockRequestDto;
import com.bookstore.restapi.enums.ErrorCodeEnum;
import com.bookstore.restapi.exception.CustomRuntimeException;
import com.bookstore.restapi.mapper.StockDtoMapper;
import com.bookstore.restapi.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockAdapter adapter;
    private final BookAdapter bookAdapter;
    private final StockDtoMapper mapper;

    @Override
    public Boolean updateBookOfStock(UpdateStockRequestDto request) {
        Optional<BookDomain> book = bookAdapter.getBookById(request.getBookId());
        book.orElseThrow(() -> new CustomRuntimeException(ErrorCodeEnum.CONTENT_NOT_FOUND));

        return adapter.updateStockOfBook(mapper.toDomainObjectFromRequest(request));
    }

    @Override
    public List<StockDto> getAllStock() {
        return adapter.getAllBookOfStock().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
