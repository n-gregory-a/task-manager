package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

public final class TaskDateStartSortedListCommand extends AbstractCommand {

    public TaskDateStartSortedListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-dslist";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all tasks sorted by start date.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService()
                .showMessage("[TASK LIST SORTED BY START DATE]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        int index = 1;
        @Nullable final String currentUserId =
                bootstrap.getUserEndpoint().getCurrentUserId(bootstrap.getCurrentSession());
        for (@NotNull final Task task:
                taskEndpoint.sortTasksByDateStart(bootstrap.getCurrentSession(), currentUserId)
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
