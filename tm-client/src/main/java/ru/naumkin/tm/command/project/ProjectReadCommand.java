package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.ProjectDTO;
import ru.naumkin.tm.command.AbstractCommand;

public final class ProjectReadCommand extends AbstractCommand {

    public ProjectReadCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-read";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show project by name.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT READ]");
        bootstrap.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = bootstrap.getTerminalService().readLine();
        @NotNull final IProjectEndpoint projectService = bootstrap.getProjectEndpoint();
        @NotNull ProjectDTO project;
        project = projectService.findOneProjectByUserId(
                bootstrap.getCurrentSessionToken(), projectName
        );
        bootstrap.getTerminalService().printEntity(project);
    }

}
