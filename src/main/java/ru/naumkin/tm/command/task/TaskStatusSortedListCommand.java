package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public class TaskStatusSortedListCommand extends AbstractCommand {

    public TaskStatusSortedListCommand() {
        super(true);
    }

    @Nullable
    @Override
    public String getName() {
        return "task-slist";
    }

    @Nullable
    @Override
    public String getDescription() {
        return "Show all tasks sorted by status.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService()
                .showMessage("[TASK LIST SORTED BY STATUS]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Task task: taskService.sortByStatus(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
