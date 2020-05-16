package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

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
        serviceLocator.getTerminalService()
                .showMessage("[PROJECT LIST SORTED BY START DATE]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Project project: projectService.sortByDateStart(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
