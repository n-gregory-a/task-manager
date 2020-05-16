package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;

public class ProjectDateFinishSortedListCommand extends AbstractCommand {

    public ProjectDateFinishSortedListCommand() {
        super(true);
    }

    @NotNull
    @Override
    public String getName() {
        return "project-dflist";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show all projects sorted by finish date.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService()
                .showMessage("[PROJECT LIST SORTED BY FINISH DATE]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        int index = 1;
        @Nullable final String currentUserId = serviceLocator.getUserService().getCurrentUserId();
        for (@NotNull final Project project: projectService.sortByDateFinish(currentUserId)) {
            serviceLocator.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
