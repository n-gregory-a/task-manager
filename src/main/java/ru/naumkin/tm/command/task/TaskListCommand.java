package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public class TaskListCommand extends AbstractCommand {

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
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK LIST]");
        ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        String currentUserId = serviceLocator.getCurrentUser().getId();
        for (Task task: taskService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
