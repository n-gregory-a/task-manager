package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.service.TaskService;

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
        bootstrap.getView().showMessage("[TASK LIST]");
        TaskService taskService = bootstrap.getTaskService();
        int index = 1;
        String currentUserId = bootstrap.getCurrentUser().getId();
        for (Task task: taskService.findAll(currentUserId)) {
            bootstrap.getView().showMessage(index++ + ". " + task.toString());
        }
    }

}
