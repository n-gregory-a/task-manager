package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.service.ProjectService;

import java.io.IOException;

public class ProjectReadCommand extends AbstractCommand {

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
        Project project = getProjectByName();
        bootstrap.getView().showMessage(project.toString());
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
