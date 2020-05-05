package ru.naumkin.tm.api.repository;

import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IRepository<E extends AbstractEntity> {

    Collection<E> findAll();

    E findOne(final String name);

    E persist(final E entity);

    E merge(final E entity);

    E remove(final E entity);

    void removeAll();

}
