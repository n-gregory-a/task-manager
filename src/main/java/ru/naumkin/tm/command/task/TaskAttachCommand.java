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
import ru.naumkin.tm.error.NoTaskWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;

import java.io.IOException;

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
        @NotNull final Project project = getProjectByName();
        @NotNull final Task task = getTaskByName();
        task.setProjectId(project.getId());
        serviceLocator.getTerminalService().showMessage("[OK]");
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
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

    @NotNull
    private Task getTaskByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull Task task;
        @NotNull final String taskName = serviceLocator.getTerminalService().readLine();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        try {
            task = taskService.findOne(taskName, currentUserId);
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
