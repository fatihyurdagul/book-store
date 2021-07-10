package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticRepository extends MongoRepository<Statistic, Long> {
}
