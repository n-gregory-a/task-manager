package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.command.AbstractCommand;

public class ProjectDateFinishSortedListCommand extends AbstractCommand {

    public ProjectDateFinishSortedListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-dflist";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all projects sorted by finish date.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService()
                .showMessage("[PROJECT LIST SORTED BY FINISH DATE]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        int index = 1;
        @Nullable final String currentUserId =
                bootstrap.getUserEndpoint().getCurrentUserId(bootstrap.getCurrentSession());
        for (@NotNull final Project project:
                projectEndpoint.sortProjectsByDateFinish(bootstrap.getCurrentSession(), currentUserId)
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(project);
        }
    }

}
