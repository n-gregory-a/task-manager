package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[FIND TASKS BY PART OF NAME]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        int index = 1;
        @Nullable final String currentUserId = bootstrap.getUserEndpoint().getCurrentUserId();
        bootstrap.getTerminalService().showMessage("Enter part of name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        for (@NotNull final Task task: taskEndpoint.sortTasksByName(currentUserId, name)) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
