package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

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
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        @NotNull final String taskName = serviceLocator.getTerminalService().readLine();
        @Nullable final Task task = taskService.findOne(taskName, currentUserId);
        taskService.remove(task);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
