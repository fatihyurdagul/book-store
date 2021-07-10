package com.bookstore.persistence.repository;

import com.bookstore.persistence.entity.StatisticEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticRepository extends MongoRepository<StatisticEntity, Long> {
}
