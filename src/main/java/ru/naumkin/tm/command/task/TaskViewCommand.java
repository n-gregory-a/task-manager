package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

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
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = serviceLocator.getTerminalService().readLine();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        @NotNull final Project project = projectService.findOne(projectName, currentUserId);
        for (@NotNull final Task task: taskService.findAll(currentUserId)) {
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

}
