package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;

public final class TaskClearCommand extends AbstractCommand {

    public TaskClearCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-clear";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Remove all tasks.";
    }

    @Override
    public void execute() {
        serviceLocator.getTerminalService().showMessage("[TASK LIST CLEAR]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        taskService.removeAll(serviceLocator.getUserService().getCurrentUserId());
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
