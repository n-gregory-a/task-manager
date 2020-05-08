package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;

public final class ProjectReadCommand extends AbstractCommand {

    public ProjectReadCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-read";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show project by name.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[PROJECT READ]");
        serviceLocator.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = serviceLocator.getTerminalService().readLine();
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @NotNull Project project;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
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
