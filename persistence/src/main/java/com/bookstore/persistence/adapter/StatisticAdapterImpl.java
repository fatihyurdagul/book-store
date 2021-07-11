package com.bookstore.persistence.adapter;

import com.bookstore.adapter.StatisticAdapter;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class StatisticAdapterImpl implements StatisticAdapter {
    private final StatisticRepository repository;
}
