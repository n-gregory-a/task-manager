package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
import ru.naumkin.tm.error.TaskIsNullException;
import ru.naumkin.tm.service.TaskService;
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
        bootstrap.getTerminalService().showMessage("[TASK UPDATE]");
        bootstrap.getTerminalService().showMessage("Enter task name:");
        Task task = new Task(bootstrap.getTerminalService().readLine());
        String name = task.getName();
        TaskService taskService = bootstrap.getTaskService();
        bootstrap.getTerminalService().showMessage("Enter new name: ");
        task.setName(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new description: ");
        task.setDescription(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy): ");
        task.setDateStart(DateFormatter.convertStringToDate(bootstrap.getTerminalService().readLine()));
        bootstrap.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy): ");
        task.setDateFinish(DateFormatter.convertStringToDate(bootstrap.getTerminalService().readLine()));
        try {
            taskService.merge(task, name);
        } catch (NameIsNullException | NameIsEmptyException | TaskIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            return;
        }
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
