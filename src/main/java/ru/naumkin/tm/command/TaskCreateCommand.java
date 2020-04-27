package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.service.TaskService;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-create";
    }

    @Override
    public String getDescription() {
        return "Create new task.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[TASK CREATE]");

        TaskService taskService = bootstrap.getTaskService();

        bootstrap.getView().showMessage("Enter name:");
        Task task = new Task(bootstrap.getView().readLine());
        taskService.persist(task);
        bootstrap.getView().showMessage("[OK]");
    }

}
