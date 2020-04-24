package ru.naumkin.tm.manager;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.util.DateFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ProjectManager {

    private ProjectRepository projectRepository = new ProjectRepository();
    private TaskRepository taskRepository = new TaskRepository();

    public void createProject(BufferedReader reader) throws IOException {
        System.out.println("[PROJECT CREATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = new Project(name);
        projectRepository.persist(project);
        System.out.println("[OK]");
    }

    public void readProject(BufferedReader reader) throws IOException {
        System.out.println("[PROJECT READ]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = projectRepository.findOne(name);
        if (project != null) {
            System.out.println(project.toString());
        } else {
            System.out.println("There is no project with name " + name);
        }
    }

    public void readProjectList() {
        System.out.println("[PROJECT LIST]");
        int i = 1;
        for (Project pr: projectRepository.findAll().values()) {
            System.out.println(i++ + ": " + pr.toString());
        }
    }

    public void updateProject(BufferedReader reader) throws IOException {
        System.out.println("[PROJECT UPDATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = projectRepository.findOne(name);

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

            projectRepository.remove(name);

            project.setName(newName);
            project.setDescription(newDescription);
            project.setDateStart(DateFormatter.convertStringToDate(newDateStart));
            project.setDateFinish(DateFormatter.convertStringToDate(newDateFinish));

            projectRepository.persist(project);

            System.out.println("[OK]");
            System.out.println("Updated project:");
            System.out.println(projectRepository.findOne(name));
        } else {
            System.out.println("[There is no project with name " + name + "]");
        }

    }

    public void deleteProject(BufferedReader reader) throws IOException {
        System.out.println("[PROJECT DELETE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Project project = projectRepository.findOne(name);

        if (project != null) {
            for (Task t:findAllTasksAttachedToProject(project)) {
                taskRepository.remove(t.getName());
            }
            projectRepository.remove(name);
            System.out.println("[OK]");
        } else {
            System.out.println("[There is no project with name " + name + "]");
        }
    }

    public void deleteAllProjects() {
        projectRepository.removeAll();
        System.out.println("[OK]");
    }

    public void attachTask(BufferedReader reader) throws IOException {
        System.out.println("[ATTACH TASK TO PROJECT]");
        System.out.println("Enter project name: ");
        String projectName = reader.readLine();
        Project project = projectRepository.findOne(projectName);

        System.out.println("Enter task name: ");
        String taskName = reader.readLine();
        Task task = taskRepository.findOne(taskName);
        project.getTaskIdList().add(task.getID());
        task.setProjectId(project.getID());
        System.out.println("[OK]");
    }

    public void viewTasks(BufferedReader reader) throws IOException {
        System.out.println("[VIEW TASKS ATTACHED TO THE PROJECT]");
        System.out.println("Enter project name: ");
        String projectName = reader.readLine();
        Project project = projectRepository.findOne(projectName);

        System.out.println("[ATTACHED TASKS LIST]");
        System.out.println(findAllTasksAttachedToProject(project));;
    }

    private List<Task> findAllTasksAttachedToProject(Project project) {
        List<Task> tasks = new LinkedList<>();
        for (String taskId: project.getTaskIdList()) {
            for (Task t: taskRepository.findAll().values()) {
                boolean taskAttachedToProject = t.getID().equals(taskId);
                if (taskAttachedToProject) {
                    tasks.add(t);
                }
            }
        }
        return tasks;
    }

}
