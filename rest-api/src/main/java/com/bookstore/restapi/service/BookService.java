package com.bookstore.restapi.service;

import com.bookstore.domain.BookDomain;

import java.util.List;

public interface BookService {
    Boolean createBook(BookDomain request);

    List<BookDomain> getAllBook();
}
