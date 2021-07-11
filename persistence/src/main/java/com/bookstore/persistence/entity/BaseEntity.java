package com.bookstore.persistence.entity;

import org.springframework.data.annotation.Version;

public class BaseEntity {
    @Version
    private Long version;
}
