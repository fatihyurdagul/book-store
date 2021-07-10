package com.bookstore.restapi.service.impl;

import com.bookstore.adapterrepo.BookRepositoryAdapter;
import com.bookstore.domain.BookDomain;
import com.bookstore.restapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepositoryAdapter bookAdapter;

    @Override
    public Boolean createBook(BookDomain request) {
        return bookAdapter.saveBook(request);
    }

    @Override
    public List<BookDomain> getAllBook() {
        return bookAdapter.getAllBook();
    }
}
