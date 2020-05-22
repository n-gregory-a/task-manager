package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.api.endpoint.Session;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.command.AbstractCommand;

public final class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-create";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Create new project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT CREATE]");
        @Nullable final Session session
                = bootstrap.getCurrentSession();
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        bootstrap.getTerminalService().showMessage("Enter name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        @Nullable final Project project = new Project();
        project.setName(name);
        project.setUserId(session.getId());
        projectEndpoint.persistProject(session, project);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
