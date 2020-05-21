package ru.naumkin.tm.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.entity.AbstractEntity;

import java.sql.Connection;

@NoArgsConstructor
public abstract class AbstractRepository<E extends AbstractEntity> {

    @Getter
    @NotNull
    private Connection connection;

    public AbstractRepository(@NotNull final Connection connection) {
        this.connection = connection;
    }

}