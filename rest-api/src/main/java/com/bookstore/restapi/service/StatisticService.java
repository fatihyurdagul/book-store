package com.bookstore.restapi.service;

import com.bookstore.restapi.domain.StatisticDto;

import java.util.List;

public interface StatisticService {
    List<StatisticDto> getMonthlyStatistic(String customerId);
}
