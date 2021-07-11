package com.bookstore.persistence.adapter;

import com.bookstore.adapter.OrderAdapter;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class OrderAdapterImpl implements OrderAdapter {

    private final OrderRepository repository;

    @Override
    public Boolean saveOrder() {
        return null;
    }
}
