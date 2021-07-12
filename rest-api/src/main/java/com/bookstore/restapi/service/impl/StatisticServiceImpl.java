package com.bookstore.restapi.service.impl;

import com.bookstore.adapter.StatisticAdapter;
import com.bookstore.restapi.domain.StatisticDto;
import com.bookstore.restapi.domain.response.ResponseWrapper;
import com.bookstore.restapi.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticAdapter adapter;

    @Override
    public ResponseWrapper<List<StatisticDto>> getMonthlyStatistic(String customerId) {
        return null;
    }
}
