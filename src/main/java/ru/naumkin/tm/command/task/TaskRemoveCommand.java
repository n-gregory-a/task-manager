package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;
import ru.naumkin.tm.service.TaskService;

import java.io.IOException;

public class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "task-remove";
    }

    @Override
    public String getDescription() {
        return "Remove selected task.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[TASK REMOVE]");
        TaskService taskService = bootstrap.getTaskService();
        String currentUserId = bootstrap.getCurrentUser().getId();
        if (taskService.findAll(currentUserId).isEmpty()) {
            bootstrap.getTerminalService().showMessage("[Task list is empty]");
            return;
        }
        Task task = getTaskByName();
        taskService.remove(task);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    private Task getTaskByName() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter task name:");
        TaskService taskService = bootstrap.getTaskService();
        Task task;
        String taskName = bootstrap.getTerminalService().readLine();
        String currentUserId = bootstrap.getCurrentUser().getId();
        try {
            task = taskService.findOne(taskName, currentUserId);
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
