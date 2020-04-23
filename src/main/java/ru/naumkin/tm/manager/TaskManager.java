package ru.naumkin.tm.manager;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.util.DateFormatter;

import java.io.BufferedReader;
import java.io.IOException;

public class TaskManager {

    private TaskRepository taskRepository = new TaskRepository();

    public void createTask(BufferedReader reader) throws IOException {
        System.out.println("[TASK CREATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Task task = new Task(name);
        taskRepository.persist(task);
        System.out.println("[OK]");
    }

    public void readTask(BufferedReader reader) throws IOException {
        System.out.println("[TASK READ]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Task task = taskRepository.findOne(name);
        if (task != null) {
            System.out.println(task.toString());
        } else {
            System.out.println("There is no task with name " + name);
        }
    }

    public void readTaskList() {
        System.out.println("[TASK LIST]");
        int i = 1;
        for (Task t: taskRepository.findAll().values()) {
            System.out.println(i++ + ": " + t.toString());
        }
    }

    public void updateTask(BufferedReader reader) throws IOException {
        System.out.println("[TASK UPDATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Task task = taskRepository.findOne(name);

        if (task != null) {
            System.out.println("Following task will be updated:");
            System.out.println(task.toString());

            System.out.println("Enter name: ");
            String newName = reader.readLine();

            System.out.println("Enter description: ");
            String newDescription = reader.readLine();

            System.out.println("Enter start date(dd.mm.yyyy): ");
            String newDateStart = reader.readLine();

            System.out.println("Enter finish date(dd.mm.yyyy): ");
            String newDateFinish = reader.readLine();

            taskRepository.remove(name);

            task.setName(newName);
            task.setDescription(newDescription);
            task.setDateStart(DateFormatter.convertStringToDate(newDateStart));
            task.setDateFinish(DateFormatter.convertStringToDate(newDateFinish));

            taskRepository.persist(task);

            System.out.println("[DONE]");
            System.out.println("Updated task:");
            System.out.println(taskRepository.findAll());
        } else {
            System.out.println("[There is no task with name " + name + "]");
        }

    }

    public void deleteTask(BufferedReader reader) throws IOException {
        System.out.println("[TASK DELETE]");
        System.out.println("Enter name:");
        String name = reader.readLine();
        Task task = taskRepository.findOne(name);

        if (task != null) {
            taskRepository.remove(name);
            System.out.println("[OK]");
        } else {
            System.out.println("[There is no task with name " + name + "]");
        }
    }

    public void deleteAllTasks() {
        taskRepository.removeAll();
        System.out.println("[DONE]");
    }

}
