package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.OrderDto;
import com.bookstore.restapi.domain.request.OrderItemDto;

import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderDto createOrder(String customerId, List<OrderItemDto> request);

    List<OrderDto> getOrdersByCustomerId(String customerId);

    OrderDto getOrdersById(String orderId);

    List<OrderDto> filterOrdersByDateRange(Date from, Date to);
}
