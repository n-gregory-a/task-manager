package ru.naumkin.tm.command.task;

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

public class TaskAttachCommand extends AbstractCommand {

    public TaskAttachCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "task-attach";
    }

    @Override
    public String getDescription() {
        return "Attach task to the project.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[TASK ATTACH]");
        Project project = getProjectByName();
        Task task = getTaskByName();
        task.setProjectId(project.getId());
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    private Project getProjectByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        IProjectService projectService = serviceLocator.getProjectService();
        Project project;
        String projectName = serviceLocator.getTerminalService().readLine();
        String currentUserId = serviceLocator.getCurrentUser().getId();
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

    private Task getTaskByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter task name:");
        ITaskService taskService = serviceLocator.getTaskService();
        Task task;
        String taskName = serviceLocator.getTerminalService().readLine();
        String currentUserId = serviceLocator.getCurrentUser().getId();
        try {
            task = taskService.findOne(taskName, currentUserId);
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
