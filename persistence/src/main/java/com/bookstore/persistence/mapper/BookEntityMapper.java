package com.bookstore.persistence.mapper;

import com.bookstore.domain.BookDomain;
import com.bookstore.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookEntityMapper extends BaseMapper<BookEntity, BookDomain> {
}
