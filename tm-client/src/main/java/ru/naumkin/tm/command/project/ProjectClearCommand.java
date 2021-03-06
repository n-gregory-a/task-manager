package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.command.AbstractCommand;

public final class ProjectClearCommand extends AbstractCommand {

    public ProjectClearCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-clear";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Remove all projects.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT CLEAR]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        projectEndpoint.removeAllProjectsByUserId(bootstrap.getCurrentSessionToken());
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
