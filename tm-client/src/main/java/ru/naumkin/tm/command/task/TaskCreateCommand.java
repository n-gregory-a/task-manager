package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Session;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService().showMessage("[TASK CREATE]");
        @Nullable final Session session =
                bootstrap.getCurrentSession();
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        bootstrap.getTerminalService().showMessage("Enter name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        @NotNull Task task = new Task();
        task.setName(name);
        task.setUserId(session.getId());
        taskEndpoint.persistTask(session, task);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
