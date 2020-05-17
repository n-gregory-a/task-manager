package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
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
    public void execute() {
        bootstrap.getTerminalService().showMessage("[PROJECT LIST]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        int index = 1;
        @Nullable final String currentUserId = bootstrap.getUserEndpoint().getCurrentUserId();
        for (@NotNull final Project project: projectEndpoint.findAllProjectsByUserId(currentUserId)) {
            bootstrap.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
