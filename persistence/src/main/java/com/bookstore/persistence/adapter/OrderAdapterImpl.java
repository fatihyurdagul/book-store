package com.bookstore.persistence.adapter;

import com.bookstore.adapter.OrderAdapter;
import com.bookstore.domain.OrderDomain;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.entity.OrderEntity;
import com.bookstore.persistence.mapper.OrderEntityMapper;
import com.bookstore.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class OrderAdapterImpl implements OrderAdapter {

    private final OrderRepository repository;
    private final OrderEntityMapper mapper;

    @Override
    public OrderDomain saveOrder(OrderDomain order) {
        OrderEntity orderEntity = mapper.toEntity(order);
        return mapper.toDomainObject(repository.save(orderEntity));
    }

    @Override
    public List<OrderDomain> getOrdersByCustomerId(String customerId) {
        List<OrderEntity> orderEntityByCustomerId = repository.findOrderEntityByCustomerId(customerId);
        return orderEntityByCustomerId.stream().map(mapper::toDomainObject).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDomain> getOrdersById(String orderId) {
        return repository.findOrderEntityById(orderId).map(mapper::toDomainObject);
    }

    @Override
    public List<OrderDomain> filterOrdersByDateRange(Date from, Date to) {
        return repository.findOrderEntityByCreatedDateBetween(from, to).stream()
                .map(mapper::toDomainObject).collect(Collectors.toList());
    }
}
