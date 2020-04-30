package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;
import ru.naumkin.tm.service.TaskService;

import java.io.IOException;

public class TaskReadCommand extends AbstractCommand {

    public TaskReadCommand() {
        super(true);
    }

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
        Task task = getTaskByName();
        bootstrap.getView().showMessage(task.toString());
    }

    private Task getTaskByName() throws IOException {
        bootstrap.getView().showMessage("Enter task name:");
        TaskService taskService = bootstrap.getTaskService();
        Task task;
        try {
            task = taskService.findOne(bootstrap.getView().readLine());
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            bootstrap.getView().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
