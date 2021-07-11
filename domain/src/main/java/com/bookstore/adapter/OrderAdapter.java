package com.bookstore.adapter;

import com.bookstore.domain.OrderDomain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderAdapter {

    OrderDomain saveOrder(OrderDomain order);

    List<OrderDomain> getOrdersByCustomerId(String customerId);

    Optional<OrderDomain> getOrdersById(String orderId);

    List<OrderDomain> filterOrdersByDateRange(Date from, Date to);
}
