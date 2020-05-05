package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;

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
        bootstrap.getTerminalService().showMessage("[VIEW TASKS ATTACHED TO THE PROJECT]");
        TaskService taskService = bootstrap.getTaskService();
        Project project = getProjectByName();
        for (Task task: taskService.findAll()) {
            String projectId = task.getProjectId();
            if (projectId == null) {
                continue;
            }
            boolean taskAttachedToProject = projectId.equals(project.getId());
            if (taskAttachedToProject) {
                bootstrap.getTerminalService().showMessage(task.toString());
            }
        }
    }

    private Project getProjectByName() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter project name:");
        ProjectService projectService = bootstrap.getProjectService();
        Project project;
        String projectName = bootstrap.getTerminalService().readLine();
        String currentUserId = bootstrap.getCurrentUser().getId();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException | NoProjectWithSuchNameException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

}
