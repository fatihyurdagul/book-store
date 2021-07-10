package com.bookstore.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.bookstore.persistence.repository")
@EntityScan(basePackages = "com.bookstore.persistence.entity")
public class MongoConfiguration {
}
