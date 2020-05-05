package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;

public class TaskClearCommand extends AbstractCommand {

    public TaskClearCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "task-clear";
    }

    @Override
    public String getDescription() {
        return "Remove all tasks.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK LIST CLEAR]");
        ITaskService taskService = serviceLocator.getTaskService();
        taskService.removeAll(serviceLocator.getCurrentUser().getId());
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
