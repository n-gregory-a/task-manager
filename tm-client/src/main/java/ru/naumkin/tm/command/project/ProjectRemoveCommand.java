package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.command.AbstractCommand;

public final class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-remove";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Remove selected project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT REMOVE]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        bootstrap.getTerminalService().showMessage("Enter project name:");
        @NotNull final String projectName = bootstrap.getTerminalService().readLine();
        @NotNull final Project project =
                projectEndpoint.findOneProjectByUserId(
                        bootstrap.getCurrentSession(), projectName
                );
        projectEndpoint.removeProjectByUserId(bootstrap.getCurrentSession(), project);
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
