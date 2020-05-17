package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.command.AbstractCommand;

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
        bootstrap.getTerminalService()
                .showMessage("[PROJECT LIST SORTED BY STATUS]");
        @NotNull final IProjectEndpoint projectService = bootstrap.getProjectEndpoint();
        int index = 1;
        @Nullable final String currentUserId = bootstrap.getUserEndpoint().getCurrentUserId();
        for (@NotNull final Project project: projectService.sortProjectsByStatus(currentUserId)) {
            bootstrap.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
