package ru.naumkin.tm.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public final class Project extends AbstractEntity {

    private @NotNull String description = "";

    private @Nullable LocalDate dateStart = LocalDate.now();

    private @Nullable LocalDate dateFinish = null;

    @Nullable
    private String userId = null;

    public Project(final String name) {
        setName(name);
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(final @NotNull String description) {
        this.description = description;
    }

    public @Nullable LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(final @NotNull LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public @Nullable LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(final @Nullable LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public @Nullable String getUserId() {
        return userId;
    }

    public void setUserId(final @Nullable String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", userId='" + userId + '\'' +
                '}';
    }
}
