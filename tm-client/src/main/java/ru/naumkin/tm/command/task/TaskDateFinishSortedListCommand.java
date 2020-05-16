package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Task;

public class TaskDateFinishSortedListCommand extends AbstractCommand {

    public TaskDateFinishSortedListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-dflist";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all tasks sorted by finish date.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService()
                .showMessage("[TASK LIST SORTED BY FINISH DATE]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Task task: taskService.sortByDateFinish(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + task.toString());
        }
    }

}
