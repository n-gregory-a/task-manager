package ru.naumkin.tm.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Task extends AbstractEntity {

    private String description = "";

    private LocalDate dateStart = LocalDate.now();

    private LocalDate dateFinish = null;

    private String projectId = null;

    private String userId = null;

    public Task(String name) {
        setName(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
