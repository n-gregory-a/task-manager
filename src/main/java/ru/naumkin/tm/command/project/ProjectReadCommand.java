package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
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
        Project project = getProjectByName();
        bootstrap.getView().showMessage(project.toString());
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

}
