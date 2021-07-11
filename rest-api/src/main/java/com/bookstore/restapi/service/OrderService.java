package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.OrderDto;
import com.bookstore.restapi.domain.request.CreateOrderRequestDto;

import java.util.Date;
import java.util.List;

public interface OrderService {

    Boolean createOrder(CreateOrderRequestDto request);

    List<OrderDto> getOrdersByCustomerId(String customerId);

    OrderDto getOrdersById(String orderId);

    List<OrderDto> filterOrdersByDateRange(Date from, Date to);
}
