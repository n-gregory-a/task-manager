package ru.naumkin.tm.command.project;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;

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
        serviceLocator.getTerminalService().showMessage("[PROJECT READ]");
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        String projectName = serviceLocator.getTerminalService().readLine();
        IProjectService projectService = serviceLocator.getProjectService();
        Project project;
        String currentUserId = serviceLocator.getCurrentUser().getId();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            return;
        }
        serviceLocator.getTerminalService().showMessage(project.toString());
    }

}
