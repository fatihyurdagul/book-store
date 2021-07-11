package com.bookstore.restapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    INTERNAL_SERVER_ERROR(1000,"Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    CONTENT_NOT_FOUND(1001,"Content not found.", HttpStatus.BAD_REQUEST),
    UN_AUTHORIZATION(1003,"Un Authorized.", HttpStatus.UNAUTHORIZED),
    FIELD_VALIDATION_ERROR(1002,"Field validation error.", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
