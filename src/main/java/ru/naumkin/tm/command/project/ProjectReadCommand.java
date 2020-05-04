package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;
import ru.naumkin.tm.service.ProjectService;

import java.io.IOException;

public class ProjectReadCommand extends AbstractCommand {

    public ProjectReadCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-read";
    }

    @Override
    public String getDescription() {
        return "Show project by name.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[PROJECT READ]");
        bootstrap.getView().showMessage("Enter project name:");
        String projectName = bootstrap.getView().readLine();
        ProjectService projectService = bootstrap.getProjectService();
        Project project = null;
        String currentUserId = bootstrap.getCurrentUser().getId();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            bootstrap.getView().showMessage(e.toString());
            return;
        }
        bootstrap.getView().showMessage(project.toString());
    }

}
