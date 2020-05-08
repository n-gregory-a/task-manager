package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;

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
        if (projectService.findAll(currentUserId).isEmpty()) {
            serviceLocator.getTerminalService().showMessage("[Project list is empty.]");
            return;
        }
        @NotNull Project project;
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = serviceLocator.getTerminalService().readLine();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
            return;
        }
        try {
            projectService.remove(project, currentUserId);
        } catch (ProjectIsNullException e) {
            serviceLocator.getTerminalService().showMessage(e.toString());
        }
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
