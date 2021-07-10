package com.bookstore.restapi.aop;

import com.bookstore.restapi.domain.response.ErrorResponse;
import com.bookstore.restapi.enums.ErrorCodeEnum;
import com.bookstore.restapi.exception.CustomRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionAdviceController {

    public ResponseEntity<ErrorResponse> handleExceptionInterval(ErrorCodeEnum error) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(error.getCode())
                .message(error.getMessage()).build();

        return new ResponseEntity<>(errorResponse, error.getHttpStatus());
    }

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(CustomRuntimeException ex, WebRequest request) {
        return this.handleExceptionInterval(ex.getErrorCode());
    }
}
