package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.*;
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
        @NotNull final String sessionToken = bootstrap.getCurrentSessionToken();
        bootstrap.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = bootstrap.getTerminalService().readLine();
        @NotNull final ProjectDTO project = projectEndpoint.findOneProjectByUserId(
                sessionToken, projectName
        );
        for (@NotNull final TaskDTO task:
                taskEndpoint.findAllTasksByUserId(sessionToken)
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
