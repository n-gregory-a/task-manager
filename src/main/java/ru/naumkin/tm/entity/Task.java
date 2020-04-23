package ru.naumkin.tm.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private UUID id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private UUID projectId;

    public Task() {
    }

    public Task(String name, String description, String startDate, String endDate, UUID projectId) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
        this.projectId = projectId;
    }
}
