package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.BookDto;

import java.util.List;

public interface BookService {
    Boolean createBook(BookDto request);

    List<BookDto> getAllBook();
}
