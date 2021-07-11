package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.BookAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.restapi.domain.BookDto;
import com.bookstore.restapi.mapper.BookDtoDtoMapper;
import com.bookstore.restapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookAdapter bookAdapter;
    private final BookDtoDtoMapper mapper;

    @Override
    public Boolean createBook(BookDto request) {
        BookDomain bookDomain = mapper.toDomainObject(request);
        return bookAdapter.saveBook(bookDomain);
    }

    @Override
    public List<BookDto> getAllBook() {
        return bookAdapter.getAllBook().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
