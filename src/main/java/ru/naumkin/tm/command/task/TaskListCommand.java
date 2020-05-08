package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public final class TaskListCommand extends AbstractCommand {

    public TaskListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-list";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all tasks.";
    }

    @Override
    public void execute() {
        serviceLocator.getTerminalService().showMessage("[TASK LIST]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Task task: taskService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
