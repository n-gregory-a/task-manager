package ru.naumkin.tm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Project {

    private final String ID = UUID.randomUUID().toString();

    private String name = "";

    private String description = "";

    private LocalDate dateStart = LocalDate.now();

    private LocalDate dateFinish = null;

    private List<String> taskIdList = new ArrayList<>();

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

    public List<String> getTaskIdList() {
        return taskIdList;
    }

    public void setTaskIdList(List<String> taskIdList) {
        this.taskIdList = taskIdList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", taskIdList=" + taskIdList +
                '}';
    }

}
