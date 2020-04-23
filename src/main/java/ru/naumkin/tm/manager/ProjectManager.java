package ru.naumkin.tm.manager;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.util.DateFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProjectManager {

    private Map<String, Project> projects = new HashMap<>();

    public void createProject(BufferedReader reader) throws IOException {
        System.out.println("[PROJECT CREATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = new Project(name);
        projects.put(name, project);
        System.out.println("[OK]");
    }

    public void readProject (BufferedReader reader) throws IOException {
        System.out.println("[PROJECT READ]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = projects.get(name);
        if (project != null) {
            System.out.println(project.toString());
        } else {
            System.out.println("There is no project with name " + name);
        }
    }

    public void readProjectList () {
        System.out.println("[PROJECT LIST]");
        int i = 1;
        for (Project pr: projects.values()) {
            System.out.println(i++ + ": " + pr.toString());
        }
    }

    public void updateProject (BufferedReader reader) throws IOException {
        System.out.println("[PROJECT UPDATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = projects.get(name);

        if (project != null) {
            System.out.println("Following project will be updated:");
            System.out.println(project.toString());

            System.out.println("Enter name: ");
            String newName = reader.readLine();

            System.out.println("Enter description: ");
            String newDescription = reader.readLine();

            System.out.println("Enter start date(dd.mm.yyyy): ");
            String newDateStart = reader.readLine();

            System.out.println("Enter finish date(dd.mm.yyyy): ");
            String newDateFinish = reader.readLine();

            projects.remove(name);

            project.setName(newName);
            project.setDescription(newDescription);
            project.setDateStart(DateFormatter.convertStringToDate(newDateStart));
            project.setDateFinish(DateFormatter.convertStringToDate(newDateFinish));

            projects.put(newName, project);

            System.out.println("[DONE]");
            System.out.println("Updated project:");
            System.out.println(projects.get(newName).toString());
        } else {
            System.out.println("[There is no project with name " + name + "]");
        }

    }

    public void deleteProject (BufferedReader reader) throws IOException {
        System.out.println("[PROJECT DELETE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = projects.get(name);

        if (project != null) {
            projects.remove(name);
            System.out.println("[OK]");
        } else {
            System.out.println("[There is no project with name " + name + "]");
        }
    }

    public void deleteAllProjects () {
        projects.clear();
        System.out.println("[DONE]");
    }

}
