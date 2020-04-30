package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NameIsNullException;
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
        bootstrap.getView().showMessage("[VIEW TASKS ATTACHED TO THE PROJECT]");
        TaskService taskService = bootstrap.getTaskService();
        Project project = getProjectByName();
        for (Task task: taskService.findAll()) {
            boolean taskAttachedToProject = task.getProjectId().equals(project.getID());
            if (taskAttachedToProject) {
                bootstrap.getView().showMessage(task.toString());
            }
        }
    }

    private Project getProjectByName() throws IOException {
        bootstrap.getView().showMessage("Enter project name: ");
        ProjectService projectService = bootstrap.getProjectService();
        Project project;
        try {
            project = projectService.findOne(bootstrap.getView().readLine());
        } catch (NameIsNullException | NameIsEmptyException | NoProjectWithSuchNameException e) {
            bootstrap.getView().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

}
