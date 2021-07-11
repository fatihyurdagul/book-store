package com.bookstore.restapi.controller;

import com.bookstore.restapi.domain.BookDto;
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

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        List<BookDto> all = bookService.getAllBook();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookDto request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }
}
