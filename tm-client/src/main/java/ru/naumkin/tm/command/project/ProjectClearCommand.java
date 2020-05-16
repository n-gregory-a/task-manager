package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;

public final class ProjectClearCommand extends AbstractCommand {

    public ProjectClearCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-clear";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Remove all projects.";
    }

    @Override
    public void execute() {
        serviceLocator.getTerminalService().showMessage("[PROJECT CLEAR]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        projectService.removeAll(serviceLocator.getUserService().getCurrentUserId());
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
