package ru.naumkin.tm.manager;

import ru.naumkin.tm.entity.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    static int id;

    public void createTask (BufferedReader reader) throws IOException {
        System.out.println("[TASK CREATE]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Task task = new Task(name);
        task.setId(id++);
        tasks.put(name, task);
        System.out.println("[OK]");
    }

    public void readTask (BufferedReader reader) throws IOException {
        System.out.println("[TASK READ]");
        System.out.println("Enter name: ");
        String name = reader.readLine();
        Task task = tasks.get(name);
        if (task != null) {
            System.out.println(task.toString());
        } else {
            System.out.println("There is no task with name " + name);
        }
    }

    public void readTaskList () {
        System.out.println("[TASK LIST]");
        int i = 1;
        for (Task t: tasks.values()) {
            System.out.println(i++ + ": " + t.toString());
        }
    }

    public void updateTask (BufferedReader reader) throws IOException {
        System.out.println("[TASK UPDATE]");
        String name = reader.readLine();
        Task task = tasks.get(name);

        if (task != null) {
            System.out.println("Following task will be updated:");
            System.out.println(task.toString());

            System.out.println("Enter new name: ");
            String newName = reader.readLine();

            tasks.remove(name);

            task.setName(newName);

            tasks.put(newName, task);

            System.out.println("[DONE]");
            System.out.println("Updated task:");
            System.out.println(tasks.get(newName).toString());
        } else {
            System.out.println("[There is no task with name " + name + "]");
        }

    }

    public void deleteTask (BufferedReader reader) throws IOException {
        System.out.println("[TASK DELETE]");
        System.out.println("Enter name:");
        String name = reader.readLine();
        Task task = tasks.get(name);

        if (task != null) {
            tasks.remove(name);
            System.out.println("[OK]");
        } else {
            System.out.println("[There is no task with name " + name + "]");
        }
    }

    public void deleteAllTasks() {
        tasks.clear();
        System.out.println("[DONE]");
    }
}
