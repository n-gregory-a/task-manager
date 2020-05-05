package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
import ru.naumkin.tm.error.TaskIsNullException;
import ru.naumkin.tm.util.DateFormatter;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "task-update";
    }

    @Override
    public String getDescription() {
        return "Update task.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK UPDATE]");
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        Task task = new Task(serviceLocator.getTerminalService().readLine());
        String name = task.getName();
        ITaskService taskService = serviceLocator.getTaskService();
        serviceLocator.getTerminalService().showMessage("Enter new name: ");
        task.setName(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new description: ");
        task.setDescription(serviceLocator.getTerminalService().readLine());
        serviceLocator.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy): ");
        task.setDateStart(DateFormatter.convertStringToDate(serviceLocator.getTerminalService().readLine()));
        serviceLocator.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy): ");
        task.setDateFinish(DateFormatter.convertStringToDate(serviceLocator.getTerminalService().readLine()));
        try {
            taskService.merge(task, name);
        } catch (NameIsNullException | NameIsEmptyException | TaskIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            return;
        }
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
