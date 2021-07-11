package com.bookstore.persistence.mapper;

import com.bookstore.domain.StatisticDomain;
import com.bookstore.persistence.entity.StatisticEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticEntityMapper extends BaseEntityMapper<StatisticEntity, StatisticDomain> {
}
