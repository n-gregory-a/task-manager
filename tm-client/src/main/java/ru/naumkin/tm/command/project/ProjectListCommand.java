package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.ProjectDTO;
import ru.naumkin.tm.command.AbstractCommand;

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
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT LIST]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        int index = 1;
        for (@NotNull final ProjectDTO project:
                projectEndpoint.findAllProjectsByUserId(bootstrap.getCurrentSessionToken())
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(project);
        }
    }

}
