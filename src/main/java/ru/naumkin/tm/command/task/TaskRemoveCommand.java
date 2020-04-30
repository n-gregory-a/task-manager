package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;
import ru.naumkin.tm.service.TaskService;

import java.io.IOException;

public class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand() {
        super(true);
    }

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
            return;
        }
        Task task = getTaskByName();
        taskService.remove(task);
        bootstrap.getView().showMessage("[OK]");
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
