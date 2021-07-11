package com.bookstore.restapi.controller;

import com.bookstore.restapi.domain.OrderDto;
import com.bookstore.restapi.domain.request.CreateOrderRequestDto;
import com.bookstore.restapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> createOrder(@Valid @RequestBody CreateOrderRequestDto request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrdersById(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrdersById(orderId));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrdersByDateRange(@RequestParam("from") Date from, @RequestParam("to") Date to) {
        return ResponseEntity.ok(orderService.filterOrdersByDateRange(from, to));
    }
}
