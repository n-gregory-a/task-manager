package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;

import java.io.IOException;

public final class TaskReadCommand extends AbstractCommand {

    public TaskReadCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-read";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show task by name";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK READ]");
        @NotNull final Task task = getTaskByName();
        serviceLocator.getTerminalService().showMessage(task.toString());
    }

    @NotNull
    private Task getTaskByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull Task task;
        @NotNull final String taskName = serviceLocator.getTerminalService().readLine();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        try {
            task = taskService.findOne(taskName, currentUserId);
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
