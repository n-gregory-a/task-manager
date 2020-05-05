package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;

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
        serviceLocator.getTerminalService().showMessage("[TASK REMOVE]");
        ITaskService taskService = serviceLocator.getTaskService();
        String currentUserId = serviceLocator.getCurrentUser().getId();
        if (taskService.findAll(currentUserId).isEmpty()) {
            serviceLocator.getTerminalService().showMessage("[Task list is empty]");
            return;
        }
        Task task = getTaskByName();
        taskService.remove(task);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    private Task getTaskByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        ITaskService taskService = serviceLocator.getTaskService();
        Task task;
        String taskName = serviceLocator.getTerminalService().readLine();
        String currentUserId = serviceLocator.getCurrentUser().getId();
        try {
            task = taskService.findOne(taskName, currentUserId);
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
