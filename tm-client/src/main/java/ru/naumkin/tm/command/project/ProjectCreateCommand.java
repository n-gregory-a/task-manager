package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
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
        @Nullable final User user
                = bootstrap.getUserEndpoint().getCurrentUser();
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        bootstrap.getTerminalService().showMessage("Enter name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        @Nullable final Project project = new Project();
        project.setName(name);
        if (user != null) {
            project.setUserId(user.getId());
        }
        projectEndpoint.persistProject(bootstrap.getCurrentSession(), project);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
