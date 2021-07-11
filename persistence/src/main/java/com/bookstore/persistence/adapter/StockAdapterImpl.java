package com.bookstore.persistence.adapter;

import com.bookstore.adapter.StockAdapter;
import com.bookstore.domain.StockDomain;
import com.bookstore.persistence.common.PersistenceAdapter;
import com.bookstore.persistence.entity.StockEntity;
import com.bookstore.persistence.mapper.StockEntityMapper;
import com.bookstore.persistence.repository.StockRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class StockAdapterImpl implements StockAdapter {

    private final StockRepository repository;
    private final StockEntityMapper mapper;

    @Override
    public Boolean updateStockOfBook(StockDomain stockOfBook) {
        StockEntity stockEntity = mapper.toEntity(stockOfBook);
        StockEntity result = repository.save(stockEntity);
        return result != null;
    }

    @Override
    public List<StockDomain> getAllBookOfStock() {
        return repository.findAll().stream().map(mapper::toDomainObject).collect(Collectors.toList());
    }
}
