package com.bookstore.restapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    public ResponseEntity<Boolean> registerCustomer() {
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
