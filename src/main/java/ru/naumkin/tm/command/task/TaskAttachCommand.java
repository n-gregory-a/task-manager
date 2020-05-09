package ru.naumkin.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

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
        serviceLocator.getTerminalService().showMessage("[TASK ATTACH]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        @NotNull Project project;
        @NotNull final String projectName = serviceLocator.getTerminalService().readLine();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        project = projectService.findOne(projectName, currentUserId);
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        @NotNull final String taskName = serviceLocator.getTerminalService().readLine();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @Nullable final Task task;
        task = taskService.findOne(taskName, currentUserId);
        if (task != null) {
            task.setProjectId(project.getId());
        }
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
