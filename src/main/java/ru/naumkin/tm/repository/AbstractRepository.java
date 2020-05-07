package ru.naumkin.tm.repository;

import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractRepository<E extends AbstractEntity> implements IRepository<E> {

    protected final Map<String, E> map = new LinkedHashMap<>();

    @Override
    public Collection<E> findAll() {
        return map.values();
    }

    @Override
    public E findOne(final String name) {
        String id = null;
        for (final E entity: findAll()) {
            if (name.equals(entity.getName())) {
                id = entity.getId();
            }
        }
        return map.get(id);
    }

    @Override
    public E persist(final E entity) {
        return map.put(entity.getId(), entity);
    }

    @Override
    public E merge(final E entity) {
        if (entity == null) {
            return null;
        }
        return map.put(entity.getId(), entity);
    }

    @Override
    public E remove(final E entity) {
        return map.remove(entity.getId());
    }

    @Override
    public void removeAll() {
        map.clear();
    }

}