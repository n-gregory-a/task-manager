package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.entity.AbstractEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
public abstract class AbstractRepository<E extends AbstractEntity> implements IRepository<E> {

    @NotNull
    protected final Map<String, E> map = new LinkedHashMap<>();

    @NotNull
    @Override
    public Collection<E> findAll() {
        return map.values();
    }

    @Nullable
    @Override
    public E findOne(@NotNull final String name) {
        String id = null;
        for (@NotNull final E entity: findAll()) {
            if (name.equals(entity.getName())) {
                id = entity.getId();
            }
        }
        return map.get(id);
    }

    @Nullable
    @Override
    public E findOneById(@NotNull final String id) {
        return map.get(id);
    }

    @Nullable
    @Override
    public E persist(@NotNull final E entity) {
        return map.put(entity.getId(), entity);
    }

    @Nullable
    @Override
    public E merge(@Nullable final E entity) {
        if (entity == null) {
            return null;
        }
        return map.put(entity.getId(), entity);
    }

    @Nullable
    @Override
    public E remove(@NotNull final E entity) {
        return map.remove(entity.getId());
    }

    @Override
    public void removeAll() {
        map.clear();
    }

    @Override
    public void persist(E[] entities) {
        for (E entity: entities) {
            map.put(entity.getId(), entity);
        }
    }
}