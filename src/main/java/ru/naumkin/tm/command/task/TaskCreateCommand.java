package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

public final class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-create";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Create new task.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK CREATE]");
        @NotNull final User user = serviceLocator.getUserService().getCurrentUser();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        serviceLocator.getTerminalService().showMessage("Enter name:");
        @NotNull Task task = new Task(serviceLocator.getTerminalService().readLine());
        task.setUserId(user.getId());
        taskService.persist(task);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
