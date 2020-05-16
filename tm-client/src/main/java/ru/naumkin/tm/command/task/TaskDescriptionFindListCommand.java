package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public class TaskDescriptionFindListCommand extends AbstractCommand {

    public TaskDescriptionFindListCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "task-dname";
    }

    @Override
    public @Nullable String getDescription() {
        return "Find tasks by part of description.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[FIND TASKS BY PART OF DESCRIPTION]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        serviceLocator.getTerminalService().showMessage("Enter part of description:");
        @NotNull final String description = serviceLocator.getTerminalService().readLine();
        for (@NotNull final Task task: taskService.sortByDescription(currentUserId, description)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
