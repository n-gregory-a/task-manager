package ru.naumkin.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;

@NoArgsConstructor
public class AbstractRepository {

    @NotNull
    protected EntityManager entityManager;

    public AbstractRepository(@NotNull final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
