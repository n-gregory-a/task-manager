package ru.naumkin.tm.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Project {

    private UUID id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    public Project() {
    }

    public Project(String name, String description, String startDate, String endDate) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public UUID getId() {
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

    public String getStartDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(startDate);
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate);
    }

    public String getEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(endDate);
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }
}
