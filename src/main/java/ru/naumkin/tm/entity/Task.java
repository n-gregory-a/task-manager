package ru.naumkin.tm.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Task {

    private String id = UUID.randomUUID().toString();

    private String name = "";

    private String description = "";

    private LocalDate dateStart = LocalDate.now();

    private LocalDate dateFinish = null;

    private String projectId;

    public String getId() {
        return id;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
