package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.service.ProjectService;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-create";
    }

    @Override
    public String getDescription() {
        return "Create new project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[PROJECT CREATE]");

        ProjectService projectService = bootstrap.getProjectService();
        bootstrap.getView().showMessage("Enter name:");
        Project project = new Project(bootstrap.getView().readLine());
        projectService.persist(project);
        bootstrap.getView().showMessage("[OK]");
    }

}
