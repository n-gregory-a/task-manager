package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.service.TaskService;

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
        bootstrap.getView().showMessage("[TASK ATTACH]");
        Project project = getProjectByName();
        Task task = getTaskByName();
        task.setProjectId(project.getID());
        bootstrap.getView().showMessage("[OK]");
    }

    private Project getProjectByName() throws IOException {
        bootstrap.getView().showMessage("Enter project name:");
        ProjectService projectService = bootstrap.getProjectService();
        Project project;
        String projectName = bootstrap.getView().readLine();
        String currentUserId = bootstrap.getCurrentUser().getID();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException | NoProjectWithSuchNameException e) {
            bootstrap.getView().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

    private Task getTaskByName() throws IOException {
        bootstrap.getView().showMessage("Enter task name:");
        TaskService taskService = bootstrap.getTaskService();
        Task task;
        try {
            task = taskService.findOne(bootstrap.getView().readLine());
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            bootstrap.getView().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
