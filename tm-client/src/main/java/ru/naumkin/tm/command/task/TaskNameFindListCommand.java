package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public class TaskNameFindListCommand extends AbstractCommand {

    public TaskNameFindListCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "task-fname";
    }

    @Override
    public @Nullable String getDescription() {
        return "Find tasks by part of name.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[FIND TASKS BY PART OF NAME]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        serviceLocator.getTerminalService().showMessage("Enter part of name:");
        @NotNull final String name = serviceLocator.getTerminalService().readLine();
        for (@NotNull final Task task: taskService.sortByName(currentUserId, name)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
