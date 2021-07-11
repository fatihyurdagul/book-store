package com.bookstore.adapter;

import com.bookstore.domain.BookDomain;

import java.util.List;

public interface BookAdapter {
    Boolean saveBook(BookDomain request);

    List<BookDomain> getAllBook();
}
