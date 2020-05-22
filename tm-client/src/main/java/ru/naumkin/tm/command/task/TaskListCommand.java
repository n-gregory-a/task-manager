package ru.naumkin.tm.command.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;

public final class TaskListCommand extends AbstractCommand {

    public TaskListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-list";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all tasks.";
    }

    @Override
    public void execute() throws JsonProcessingException {
        bootstrap.getTerminalService().showMessage("[TASK LIST]");
        @NotNull final ITaskEndpoint taskService = bootstrap.getTaskEndpoint();
        int index = 1;
        for (@NotNull final Task task:
                taskService.findAllTasksByUserId(bootstrap.getCurrentSession())
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(task);
        }
    }

}
