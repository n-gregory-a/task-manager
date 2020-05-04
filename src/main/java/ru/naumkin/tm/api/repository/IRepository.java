package ru.naumkin.tm.api.repository;

import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IRepository<E extends AbstractEntity> {

    Collection<E> findAll();

    E findOne(String name);

    E persist(E entity);

    E merge(E entity);

    E remove(E entity);

    void removeAll();

}
