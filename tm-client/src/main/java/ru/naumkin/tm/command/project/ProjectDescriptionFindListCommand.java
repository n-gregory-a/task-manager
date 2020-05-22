package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.endpoint.IProjectEndpoint;
import ru.naumkin.tm.api.endpoint.Project;
import ru.naumkin.tm.command.AbstractCommand;

public class ProjectDescriptionFindListCommand extends AbstractCommand {

    public ProjectDescriptionFindListCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "project-dname";
    }

    @Override
    public @Nullable String getDescription() {
        return "Find projects by part of description.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[FIND PROJECTS BY PART OF DESCRIPTION]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        int index = 1;
        bootstrap.getTerminalService().showMessage("Enter part of description:");
        @NotNull final String description = bootstrap.getTerminalService().readLine();
        for (@NotNull final Project project:
                projectEndpoint.sortProjectsByDescription(
                        bootstrap.getCurrentSession(), description
                )
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(project);
        }
    }

}
