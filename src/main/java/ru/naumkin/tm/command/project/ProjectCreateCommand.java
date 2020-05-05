package ru.naumkin.tm.command.project;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.User;

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
        serviceLocator.getTerminalService().showMessage("[PROJECT CREATE]");
        User user = serviceLocator.getCurrentUser();
        IProjectService projectService = serviceLocator.getProjectService();
        serviceLocator.getTerminalService().showMessage("Enter name:");
        Project project = new Project(serviceLocator.getTerminalService().readLine());
        project.setUserId(user.getId());
        projectService.persist(project);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
