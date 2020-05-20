package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[TASK REMOVE]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        @Nullable final String currentUserId =
                bootstrap.getUserEndpoint().getCurrentUserId(bootstrap.getCurrentSession());
        bootstrap.getTerminalService().showMessage("Enter task name:");
        @NotNull final String taskName = bootstrap.getTerminalService().readLine();
        @Nullable final Task task = taskEndpoint.findOneTaskByUserId(
                bootstrap.getCurrentSession(), currentUserId, taskName
        );
        taskEndpoint.removeTaskByUserId(bootstrap.getCurrentSession(), currentUserId, task);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
