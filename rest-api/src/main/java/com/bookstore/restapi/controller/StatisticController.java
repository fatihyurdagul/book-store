package com.bookstore.restapi.controller;

import com.bookstore.restapi.domain.StatisticDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import com.bookstore.restapi.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statistics")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<ResponseWrapper<List<StatisticDto>>> getMonthlyStatistic(@PathVariable String customerId) {
        return ResponseEntity.ok(statisticService.getMonthlyStatistic(customerId));
    }
}
