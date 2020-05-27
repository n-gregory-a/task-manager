package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

public final class TaskListCommand extends AbstractCommand {

    public TaskListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-list";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all tasks.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[TASK LIST]");
        @NotNull final ITaskEndpoint taskService = bootstrap.getTaskEndpoint();
        int index = 1;
        for (@NotNull final Task task:
                taskService.findAllTasksByUserId(bootstrap.getCurrentSessionToken())
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
