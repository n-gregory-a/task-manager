package ru.naumkin.tm.command.project;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;

public class ProjectClearCommand extends AbstractCommand {

    public ProjectClearCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-clear";
    }

    @Override
    public String getDescription() {
        return "Remove all projects.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[PROJECT CLEAR]");
        IProjectService projectService = serviceLocator.getProjectService();
        projectService.removeAll(serviceLocator.getCurrentUser().getId());
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
