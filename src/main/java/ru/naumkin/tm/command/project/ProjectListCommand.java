package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public final class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-list";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all projects.";
    }

    @Override
    public void execute() {
        serviceLocator.getTerminalService().showMessage("[PROJECT LIST]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Project project: projectService.findAll(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
