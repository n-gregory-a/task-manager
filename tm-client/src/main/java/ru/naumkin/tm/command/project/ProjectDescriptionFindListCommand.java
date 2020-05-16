package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public class ProjectDescriptionFindListCommand extends AbstractCommand {

    public ProjectDescriptionFindListCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "project-dname";
    }

    @Override
    public @Nullable String getDescription() {
        return "Find projects by part of description.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[FIND PROJECTS BY PART OF DESCRIPTION]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        serviceLocator.getTerminalService().showMessage("Enter part of description:");
        @NotNull final String description = serviceLocator.getTerminalService().readLine();
        for (@NotNull final Project project: projectService.sortByDescription(currentUserId, description)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }
}
