package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.TaskDTO;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[FIND TASKS BY PART OF DESCRIPTION]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        int index = 1;
        bootstrap.getTerminalService().showMessage("Enter part of description:");
        @NotNull final String description = bootstrap.getTerminalService().readLine();
        for (@NotNull final TaskDTO task:
                taskEndpoint.sortTasksByDescription(
                        bootstrap.getCurrentSessionToken(), description)
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
