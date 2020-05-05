package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

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
        serviceLocator.getTerminalService().showMessage("[TASK CREATE]");
        User user = serviceLocator.getCurrentUser();
        ITaskService taskService = serviceLocator.getTaskService();
        serviceLocator.getTerminalService().showMessage("Enter name:");
        Task task = new Task(serviceLocator.getTerminalService().readLine());
        task.setUserId(user.getId());
        taskService.persist(task);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
