package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.command.AbstractCommand;

public final class ProjectDateStartSortedListCommand extends AbstractCommand {

    public ProjectDateStartSortedListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-dslist";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all projects sorted by start date.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService()
                .showMessage("[PROJECT LIST SORTED BY START DATE]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        int index = 1;
        for (@NotNull final Project project:
                projectEndpoint.sortProjectsByDateStart(bootstrap.getCurrentSession())
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(project);
        }
    }

}
