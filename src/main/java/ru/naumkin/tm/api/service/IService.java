package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IService<E extends AbstractEntity> {

    Collection<E> findAll();

    E findOne(final String name);

    E persist(final E entity);

    E merge(final E entity, final String name);

    E remove(final E entity);

    void removeAll();

}
