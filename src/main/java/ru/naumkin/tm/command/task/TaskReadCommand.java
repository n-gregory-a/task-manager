package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;

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
        serviceLocator.getTerminalService().showMessage("[TASK READ]");
        Task task = getTaskByName();
        serviceLocator.getTerminalService().showMessage(task.toString());
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
