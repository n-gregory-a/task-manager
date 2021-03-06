package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.TaskDTO;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService()
                .showMessage("[TASK LIST SORTED BY FINISH DATE]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        int index = 1;
        for (@NotNull final TaskDTO task:
                taskEndpoint.sortTasksByDateFinish(bootstrap.getCurrentSessionToken())
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
