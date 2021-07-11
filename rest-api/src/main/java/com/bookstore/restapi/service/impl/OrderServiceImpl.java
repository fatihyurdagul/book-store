package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.adapter.OrderAdapter;
import com.bookstore.adapter.StockAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.domain.OrderDomain;
import com.bookstore.domain.StockDomain;
import com.bookstore.restapi.domain.OrderDto;
import com.bookstore.restapi.domain.request.OrderItemDto;
import com.bookstore.restapi.enums.ErrorCodeEnum;
import com.bookstore.restapi.exception.CustomRuntimeException;
import com.bookstore.restapi.mapper.OrderDtoMapper;
import com.bookstore.restapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderAdapter adapter;
    private final BookAdapter bookAdapter;
    private final StockAdapter stockAdapter;
    private final OrderDtoMapper mapper;

    @Override
    public OrderDto createOrder(String customerId, List<OrderItemDto> request) {
        if (request.isEmpty())
            throw new CustomRuntimeException(ErrorCodeEnum.FIELD_VALIDATION_ERROR);

        OrderDomain orderDomain = new OrderDomain(customerId);

        List<StockDomain> stockList = new ArrayList<>();
        for (OrderItemDto order : request) {
            Optional<BookDomain> book = bookAdapter.getBookById(order.getBookId());
            book.orElseThrow(() -> new CustomRuntimeException(ErrorCodeEnum.CONTENT_NOT_FOUND));

            Optional<StockDomain> stockOfBook = stockAdapter.getStockOfBook(order.getBookId());
            if (!stockOfBook.isPresent() || order.getQuantity() > stockOfBook.get().getStock())
                throw new CustomRuntimeException(ErrorCodeEnum.STOCK_ERROR);

            StockDomain stockDomain = stockOfBook.get();
            stockDomain.updateStockOfBook(order.getQuantity());
            stockList.add(stockDomain);

            orderDomain.addItem(book.get(), order.getQuantity());
        }

        stockAdapter.updateStockOfMultipleBook(stockList);

        return mapper.toDTO(adapter.saveOrder(orderDomain));
    }


    @Override
    public List<OrderDto> getOrdersByCustomerId(String customerId) {
        return adapter.getOrdersByCustomerId(customerId).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrdersById(String orderId) {
        Optional<OrderDomain> order = adapter.getOrdersById(orderId);
        order.orElseThrow(() -> new CustomRuntimeException(ErrorCodeEnum.CONTENT_NOT_FOUND));

        return order.map(mapper::toDTO).get();
    }

    @Override
    public List<OrderDto> filterOrdersByDateRange(Date from, Date to) {
        return adapter.filterOrdersByDateRange(from, to).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
