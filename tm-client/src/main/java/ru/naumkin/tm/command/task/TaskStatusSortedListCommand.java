package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService()
                .showMessage("[TASK LIST SORTED BY STATUS]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        int index = 1;
        @Nullable final String currentUserId = bootstrap.getUserEndpoint().getCurrentUserId();
        for (@NotNull final Task task: taskEndpoint.sortTasksByStatus(currentUserId)) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
