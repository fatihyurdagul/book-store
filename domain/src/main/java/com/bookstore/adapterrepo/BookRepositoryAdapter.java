package com.bookstore.adapterrepo;

import com.bookstore.domain.BookDomain;

import java.util.List;

public interface BookRepositoryAdapter {
    Boolean saveBook(BookDomain request);

    List<BookDomain> getAllBook();
}
