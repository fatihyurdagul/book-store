package com.bookstore.persistence.adapter;

import com.bookstore.adapterrepo.BookRepositoryAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.persistence.entity.BookEntity;
import com.bookstore.persistence.mapper.BookEntityMapper;
import com.bookstore.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookRepositoryAdapterImpl implements BookRepositoryAdapter {

    private final BookRepository repository;
    private final BookEntityMapper mapper;

    @Override
    public Boolean saveBook(BookDomain request) {
        BookEntity bookEntity = mapper.toEntity(request);
        BookEntity save = repository.save(bookEntity);
        return save != null;
    }

    @Override
    public List<BookDomain> getAllBook() {
        return repository.findAll().stream().map(mapper::toDomainObject).collect(Collectors.toList());
    }
}
