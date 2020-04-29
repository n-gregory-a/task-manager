package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.service.TaskService;

import java.io.IOException;

public class TaskReadCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-read";
    }

    @Override
    public String getDescription() {
        return "Show task by name";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[TASK READ]");
        bootstrap.getView().showMessage("Enter task name:");
        Task task = getTaskByName();
        bootstrap.getView().showMessage(task.toString());
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
