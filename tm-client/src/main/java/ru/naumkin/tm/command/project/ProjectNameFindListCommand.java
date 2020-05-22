package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;

public class ProjectNameFindListCommand extends AbstractCommand {

    public ProjectNameFindListCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "project-fname";
    }

    @Override
    public @Nullable String getDescription() {
        return "Find projects by part of name.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[FIND PROJECTS BY PART OF NAME]");
        @NotNull final IProjectEndpoint projectEndpoint = bootstrap.getProjectEndpoint();
        int index = 1;
        bootstrap.getTerminalService().showMessage("Enter part of name:");
        @NotNull final String name = bootstrap.getTerminalService().readLine();
        for (@NotNull final Project project:
                projectEndpoint.sortProjectsByName(bootstrap.getCurrentSession(), name)
        ) {
            bootstrap.getTerminalService().showMessage(index++ + ". ");
            bootstrap.getTerminalService().printEntity(project);
        }
    }

}
