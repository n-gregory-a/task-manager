package ru.naumkin.tm.command.project;

import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public final class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-list";
    }

    @Override
    public String getDescription() {
        return "Show all projects.";
    }

    @Override
    public void execute() {
        serviceLocator.getTerminalService().showMessage("[PROJECT LIST]");
        final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        final String currentUserId = serviceLocator.getCurrentUser().getId();
        for (Project project: projectService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
