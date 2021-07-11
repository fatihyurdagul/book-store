package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.OrderAdapter;
import com.bookstore.restapi.domain.OrderDto;
import com.bookstore.restapi.domain.request.CreateOrderRequestDto;
import com.bookstore.restapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderAdapter adapter;

    @Override
    public Boolean createOrder(CreateOrderRequestDto request) {
        return null;
    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(String customerId) {
        return null;
    }

    @Override
    public OrderDto getOrdersById(String orderId) {
        return null;
    }

    @Override
    public List<OrderDto> filterOrdersByDateRange(Date from, Date to) {
        return null;
    }
}
