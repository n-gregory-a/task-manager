package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public final class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-remove";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Remove selected project.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[PROJECT REMOVE]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = serviceLocator.getTerminalService().readLine();
        @NotNull final Project project = projectService.findOne(projectName, currentUserId);
        projectService.remove(project, currentUserId);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
