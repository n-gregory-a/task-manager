package ru.naumkin.tm.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Project {

    private final String ID = UUID.randomUUID().toString();

    private String name = "";

    private String description = "";

    private LocalDate dateStart = LocalDate.now();

    private LocalDate dateFinish = null;

    private String userId = null;

    public Project(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                '}';
    }
}
