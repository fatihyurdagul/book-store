package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {
}
