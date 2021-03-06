package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.TaskDTO;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[TASK READ]");
        bootstrap.getTerminalService().showMessage("Enter task name:");
        @NotNull final String taskName = bootstrap.getTerminalService().readLine();
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        @Nullable final TaskDTO task = taskEndpoint.findOneTaskByUserId(
                bootstrap.getCurrentSessionToken(), taskName
        );
        if (task != null) {
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
