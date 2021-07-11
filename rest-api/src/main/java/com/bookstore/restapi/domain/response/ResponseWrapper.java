package com.bookstore.restapi.domain.response;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private boolean success;
    private String message;
    private T data;
}
