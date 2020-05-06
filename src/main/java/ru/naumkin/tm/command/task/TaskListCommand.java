package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public final class TaskListCommand extends AbstractCommand {

    public TaskListCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "task-list";
    }

    @Override
    public String getDescription() {
        return "Show all tasks.";
    }

    @Override
    public void execute() {
        serviceLocator.getTerminalService().showMessage("[TASK LIST]");
        final ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (final Task task: taskService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
