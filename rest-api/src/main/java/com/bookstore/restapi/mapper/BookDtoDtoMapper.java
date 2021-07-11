package com.bookstore.restapi.mapper;

import com.bookstore.domain.BookDomain;
import com.bookstore.restapi.domain.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookDtoDtoMapper extends BaseDtoMapper<BookDomain, BookDto> {
}
