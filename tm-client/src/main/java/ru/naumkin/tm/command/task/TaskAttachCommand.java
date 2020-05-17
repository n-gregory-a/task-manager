package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

public final class TaskAttachCommand extends AbstractCommand {

    public TaskAttachCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "task-attach";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Attach task to the project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[TASK ATTACH]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        bootstrap.getTerminalService().showMessage("Enter project name:");
        @NotNull Project project;
        @NotNull final String projectName = bootstrap.getTerminalService().readLine();
        @Nullable final String currentUserId = bootstrap.getUserEndpoint().getCurrentUserId();
        project = projectEndpoint.findOneProjectByUserId(currentUserId, projectName);
        bootstrap.getTerminalService().showMessage("Enter task name:");
        @NotNull final String taskName = bootstrap.getTerminalService().readLine();
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        @Nullable final Task task;
        task = taskEndpoint.findOneTaskByUserId(currentUserId, taskName);
        if (task != null) {
            task.setProjectId(project.getId());
        }
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
