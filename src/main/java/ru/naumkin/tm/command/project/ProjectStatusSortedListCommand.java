package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public class ProjectStatusSortedListCommand extends AbstractCommand {

    public ProjectStatusSortedListCommand() {
        super(true);
    }

    @Nullable
    @Override
    public String getName() {
        return "project-slist";
    }

    @Nullable
    @Override
    public String getDescription() {
        return "Show all projects sorted by status.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService()
                .showMessage("[PROJECT LIST SORTED BY STATUS]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Project project: projectService.sortByStatus(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
