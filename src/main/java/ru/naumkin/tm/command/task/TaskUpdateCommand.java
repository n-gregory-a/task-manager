package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.util.DateFormatter;

import java.util.ArrayList;
import java.util.List;

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
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        serviceLocator.getTerminalService().showMessage("Tasks available to update:");
        @NotNull final List<Task> list = new ArrayList<>();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Task task: taskService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
            list.add(task);
        }
        serviceLocator.getTerminalService().showMessage("Choose task to update by number:");
        @NotNull final Task task = list.get(Integer
                .parseInt(serviceLocator.getTerminalService().readLine()) - 1);
        @Nullable final String name = task.getName();
        serviceLocator.getTerminalService().showMessage("Updating task:");
        serviceLocator.getTerminalService().showMessage("id: " + task.getId() +
                ", name: " + task.getName());
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
