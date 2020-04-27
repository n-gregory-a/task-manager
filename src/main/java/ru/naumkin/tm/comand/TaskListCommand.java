package ru.naumkin.tm.comand;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.service.TaskService;

public class TaskListCommand extends AbstractCommand {

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
        for (Task task: taskService.findAll()) {
            bootstrap.getView().showMessage(index++ + ". " + task.getName());
        }
    }

}
