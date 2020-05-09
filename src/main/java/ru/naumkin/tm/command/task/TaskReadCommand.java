package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

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
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        @NotNull final String taskName = serviceLocator.getTerminalService().readLine();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        @Nullable final Task task = taskService.findOne(taskName, currentUserId);
        if (task != null) {
            serviceLocator.getTerminalService().showMessage(task.toString());
        }
    }

}
