package ru.naumkin.tm.entity;

import java.time.LocalDate;

public final class Project extends AbstractEntity {

    private String description = "";

    private LocalDate dateStart = LocalDate.now();

    private LocalDate dateFinish = null;

    private String userId = null;

    public Project(final String name) {
        setName(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(final LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(final LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
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
