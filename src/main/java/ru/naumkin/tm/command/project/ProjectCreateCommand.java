package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.service.ProjectService;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand() {
        super(true);
    }

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
        User user = bootstrap.getCurrentUser();
        ProjectService projectService = bootstrap.getProjectService();
        bootstrap.getView().showMessage("Enter name:");
        Project project = new Project(bootstrap.getView().readLine());
        project.setUserId(user.getId());
        projectService.persist(project);
        bootstrap.getView().showMessage("[OK]");
    }

}
