package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.service.TaskService;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand() {
        super(true);
    }

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
        User user = bootstrap.getCurrentUser();
        TaskService taskService = bootstrap.getTaskService();
        bootstrap.getView().showMessage("Enter name:");
        Task task = new Task(bootstrap.getView().readLine());
        task.setUserId(user.getId());
        taskService.persist(task);
        bootstrap.getView().showMessage("[OK]");
    }

}
