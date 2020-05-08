package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;

import java.io.IOException;

public final class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-remove";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Remove selected task.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK REMOVE]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        if (taskService.findAll(currentUserId).isEmpty()) {
            serviceLocator.getTerminalService().showMessage("[Task list is empty]");
            return;
        }
        @NotNull final Task task = getTaskByName();
        taskService.remove(task);
        serviceLocator.getTerminalService().showMessage("[OK]");
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
