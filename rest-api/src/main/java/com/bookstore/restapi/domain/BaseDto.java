package com.bookstore.restapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
    private String id;
    private Long version;
}
