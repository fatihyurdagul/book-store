package com.bookstore.persistence.mapper;

import java.util.List;

public interface BaseMapper <EntityObject, DomainObject>{
    EntityObject toEntity(DomainObject domainObject);

    List<EntityObject> toListEntity(List<DomainObject> domainObjects);

    DomainObject toDomainObject(EntityObject entityObject);

    List<DomainObject> toListDomainObject(List<EntityObject> entityList);
}
