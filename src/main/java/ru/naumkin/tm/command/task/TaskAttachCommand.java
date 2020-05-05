package ru.naumkin.tm.command.task;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.NoTaskWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;
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
        bootstrap.getTerminalService().showMessage("[TASK ATTACH]");
        Project project = getProjectByName();
        Task task = getTaskByName();
        task.setProjectId(project.getId());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

    private Project getProjectByName() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter project name:");
        ProjectService projectService = bootstrap.getProjectService();
        Project project;
        String projectName = bootstrap.getTerminalService().readLine();
        String currentUserId = bootstrap.getCurrentUser().getId();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            project = getProjectByName();
        }
        return project;
    }

    private Task getTaskByName() throws IOException {
        bootstrap.getTerminalService().showMessage("Enter task name:");
        TaskService taskService = bootstrap.getTaskService();
        Task task;
        String taskName = bootstrap.getTerminalService().readLine();
        String currentUserId = bootstrap.getCurrentUser().getId();
        try {
            task = taskService.findOne(taskName, currentUserId);
        } catch (NameIsEmptyException | NoTaskWithSuchNameException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            task = getTaskByName();
        }
        return task;
    }

}
