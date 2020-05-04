package ru.naumkin.tm.api.service;

import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;

public interface IService<E extends AbstractEntity> {

    Collection<E> findAll();

    E findOne(String name);

    E persist(E entity);

    E merge(E entity, String name);

    E remove(E entity);

    void removeAll();

}
