package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public class ProjectNameFindListCommand extends AbstractCommand {

    public ProjectNameFindListCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "project-fname";
    }

    @Override
    public @Nullable String getDescription() {
        return "Find projects by part of name.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[FIND PROJECTS BY PART OF NAME]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        serviceLocator.getTerminalService().showMessage("Enter part of name:");
        @NotNull final String name = serviceLocator.getTerminalService().readLine();
        for (@NotNull final Project project: projectService.sortByName(currentUserId, name)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
