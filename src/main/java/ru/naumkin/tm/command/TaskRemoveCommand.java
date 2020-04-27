package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.service.TaskService;

import java.io.IOException;

public class TaskRemoveCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-remove";
    }

    @Override
    public String getDescription() {
        return "Remove selected task.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[TASK REMOVE]");

        TaskService taskService = bootstrap.getTaskService();

        if (taskService.findAll().isEmpty()) {
            bootstrap.getView().showMessage("[Task list is empty]");
        } else {
            Task task = getTaskByName();
            taskService.remove(task);
            bootstrap.getView().showMessage("[OK]");
        }
    }

    private Task getTaskByName() throws IOException {
        bootstrap.getView().showMessage("Enter task name:");
        TaskService taskService = bootstrap.getTaskService();
        Task task;

        try {
            task = taskService.findOne(bootstrap.getView().readLine());
        } catch (IllegalArgumentException | NullPointerException e) {
            bootstrap.getView().showMessage(e.getMessage());
            task = getTaskByName();
        }

        return task;
    }

}