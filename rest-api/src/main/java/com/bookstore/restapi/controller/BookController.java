package com.bookstore.restapi.controller;

import com.bookstore.domain.BookDomain;
import com.bookstore.restapi.domain.BookDto;
import com.bookstore.restapi.mapper.BookMapper;
import com.bookstore.restapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper mapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        List<BookDomain> all = bookService.getAllBook();
        return ResponseEntity.ok(mapper.toListDTO(all));
    }

    @PostMapping
    public ResponseEntity<Boolean> addBook(@Valid @RequestBody BookDto request) {
        BookDomain createBook = mapper.toDomainObject(request);
        Boolean result = bookService.createBook(createBook);
        return ResponseEntity.ok(result);
    }
}
