package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;

import java.io.IOException;

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
        serviceLocator.getTerminalService().showMessage("[VIEW TASKS ATTACHED TO THE PROJECT]");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull final Project project = getProjectByName();
        for (@NotNull final Task task: taskService.findAll()) {
            @Nullable final String projectId = task.getProjectId();
            if (projectId == null) {
                continue;
            }
            final boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                serviceLocator.getTerminalService().showMessage(task.toString());
            }
        }
    }

    @NotNull
    private Project getProjectByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @NotNull Project project;
        @NotNull final String projectName = serviceLocator.getTerminalService().readLine();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException | NoProjectWithSuchNameException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

}
