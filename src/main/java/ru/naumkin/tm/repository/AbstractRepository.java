package ru.naumkin.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractRepository<E extends AbstractEntity> implements IRepository<E> {

    protected final Map<String, E> map = new LinkedHashMap<>();

    @Override
    public @NotNull Collection<E> findAll() {
        return map.values();
    }

    @Override
    public @Nullable E findOne(final @NotNull String name) {
        String id = null;
        for (final E entity: findAll()) {
            if (name.equals(entity.getName())) {
                id = entity.getId();
            }
        }
        return map.get(id);
    }

    @Override
    public @Nullable E persist(final @NotNull E entity) {
        return map.put(entity.getId(), entity);
    }

    @Override
    public @Nullable E merge(final @Nullable E entity) {
        if (entity == null) {
            return null;
        }
        return map.put(entity.getId(), entity);
    }

    @Override
    public @Nullable E remove(final @NotNull E entity) {
        return map.remove(entity.getId());
    }

    @Override
    public void removeAll() {
        map.clear();
    }

}