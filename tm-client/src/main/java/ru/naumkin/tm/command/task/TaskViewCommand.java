package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.ITaskEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.api.endpoint.Task;
import ru.naumkin.tm.command.AbstractCommand;

public final class TaskViewCommand extends AbstractCommand {

    public TaskViewCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "tasks-view";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all tasks attached to the project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[VIEW TASKS ATTACHED TO THE PROJECT]");
        @NotNull final ITaskEndpoint taskEndpoint = bootstrap.getTaskEndpoint();
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        bootstrap.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = bootstrap.getTerminalService().readLine();
        @Nullable final String currentUserId =
                bootstrap.getUserEndpoint().getCurrentUserId(bootstrap.getCurrentSession());
        @NotNull final Project project = projectEndpoint.findOneProjectByUserId(
                bootstrap.getCurrentSession(), currentUserId, projectName
        );
        for (@NotNull final Task task:
                taskEndpoint.findAllTasksByUserId(bootstrap.getCurrentSession(), currentUserId)
        ) {
            @Nullable final String projectId = task.getProjectId();
            if (projectId == null) {
                continue;
            }
            final boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                bootstrap.getTerminalService().printEntity(task);
            }
        }
    }

}
