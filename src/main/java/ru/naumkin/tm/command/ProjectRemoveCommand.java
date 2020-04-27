package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.service.ProjectService;

import java.io.IOException;

public class ProjectRemoveCommand extends AbstractCommand {

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

        if (projectService.findAll().isEmpty()) {
            bootstrap.getView().showMessage("[Project list is empty.]");
        } else {
            Project project = getProjectByName();
            projectService.remove(project);
            bootstrap.getView().showMessage("[OK]");
        }
    }

    private Project getProjectByName() throws IOException {
        bootstrap.getView().showMessage("Enter project name:");
        ProjectService projectService = bootstrap.getProjectService();
        Project project;

        try {
            project = projectService.findOne(bootstrap.getView().readLine());
        } catch (IllegalArgumentException | NullPointerException e) {
            bootstrap.getView().showMessage(e.getMessage());
            project = getProjectByName();
        }

        return project;
    }

}
