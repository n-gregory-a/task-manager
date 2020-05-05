package ru.naumkin.tm.command.task;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;

import java.io.IOException;

public class TaskViewCommand extends AbstractCommand {

    public TaskViewCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "tasks-view";
    }

    @Override
    public String getDescription() {
        return "Show all tasks attached to the project.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[VIEW TASKS ATTACHED TO THE PROJECT]");
        ITaskService taskService = serviceLocator.getTaskService();
        Project project = getProjectByName();
        for (Task task: taskService.findAll()) {
            String projectId = task.getProjectId();
            if (projectId == null) {
                continue;
            }
            boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                serviceLocator.getTerminalService().showMessage(task.toString());
            }
        }
    }

    private Project getProjectByName() throws IOException {
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        IProjectService projectService = serviceLocator.getProjectService();
        Project project;
        String projectName = serviceLocator.getTerminalService().readLine();
        String currentUserId = serviceLocator.getCurrentUser().getId();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException | NoProjectWithSuchNameException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

}
