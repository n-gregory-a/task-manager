package ru.naumkin.tm.command;

import ru.naumkin.tm.service.TaskService;

public class TaskClearCommand extends AbstractCommand {

    public TaskClearCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "task-clear";
    }

    @Override
    public String getDescription() {
        return "Remove all tasks.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[TASK LIST CLEAR]");

        TaskService taskService = bootstrap.getTaskService();

        taskService.removeAll();
        bootstrap.getView().showMessage("[OK]");
    }

}
