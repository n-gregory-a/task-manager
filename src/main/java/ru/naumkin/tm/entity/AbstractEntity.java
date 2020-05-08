package ru.naumkin.tm.entity;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class AbstractEntity {

    private @NotNull String id = UUID.randomUUID().toString();

    private @NotNull String name = "";

    public @NotNull String getId() {
        return id;
    }

    public void setId(final @NotNull String id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(final @NotNull String name) {
        this.name = name;
    }

}
