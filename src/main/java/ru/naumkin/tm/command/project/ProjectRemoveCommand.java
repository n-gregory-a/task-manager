package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;
import ru.naumkin.tm.service.ProjectService;

import java.io.IOException;

public class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-remove";
    }

    @Override
    public String getDescription() {
        return "Remove selected project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[PROJECT REMOVE]");
        ProjectService projectService = bootstrap.getProjectService();
        String currentUserId = bootstrap.getCurrentUser().getId();
        if (projectService.findAll(currentUserId).isEmpty()) {
            bootstrap.getView().showMessage("[Project list is empty.]");
            return;
        }
        Project project;
        bootstrap.getView().showMessage("Enter project name:");
        String projectName = bootstrap.getView().readLine();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            bootstrap.getView().showMessage(e.toString());
            return;
        }
        try {
            projectService.remove(project, currentUserId);
        } catch (ProjectIsNullException e) {
            bootstrap.getView().showMessage(e.toString());
        }
        bootstrap.getView().showMessage("[OK]");
    }

}
