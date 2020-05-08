package ru.naumkin.tm.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public final class Task extends AbstractEntity {

    private @NotNull String description = "";

    private @NotNull LocalDate dateStart = LocalDate.now();

    private @Nullable LocalDate dateFinish = null;

    private @Nullable String projectId = null;

    private @Nullable String userId = null;

    public Task(final @NotNull String name) {
        setName(name);
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(final @NotNull String description) {
        this.description = description;
    }

    public @NotNull LocalDate getDateStart() {
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

    public @Nullable String getProjectId() {
        return projectId;
    }

    public void setProjectId(final @Nullable String projectId) {
        this.projectId = projectId;
    }

    public @Nullable String getUserId() {
        return userId;
    }

    public void setUserId(final @Nullable String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", projectId='" + projectId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
