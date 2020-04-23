package ru.naumkin.tm.entity;

import java.time.LocalDate;
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
}
