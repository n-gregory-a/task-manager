package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.util.DateFormatter;

public final class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-update";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Update task.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK UPDATE]");
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        @NotNull final Task task = new Task(serviceLocator.getTerminalService().readLine());
        @Nullable final String name = task.getName();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        serviceLocator.getTerminalService().showMessage("Enter new name: ");
        task.setName(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new description: ");
        task.setDescription(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy): ");
        task.setDateStart(DateFormatter.convertStringToDate(serviceLocator.getTerminalService().readLine()));
        serviceLocator.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy): ");
        task.setDateFinish(DateFormatter.convertStringToDate(serviceLocator.getTerminalService().readLine()));
            taskService.merge(task, name);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
