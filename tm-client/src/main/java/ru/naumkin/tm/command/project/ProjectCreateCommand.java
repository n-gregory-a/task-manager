package ru.naumkin.tm.command.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.User;

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
        serviceLocator.getTerminalService().showMessage("[PROJECT CREATE]");
        @Nullable final User user = serviceLocator.getUserService().getCurrentUser();
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        serviceLocator.getTerminalService().showMessage("Enter name:");
        @Nullable final Project project = new Project(serviceLocator.getTerminalService().readLine());
        if (user != null) {
            project.setUserId(user.getId());
        }
        projectService.persist(project);
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
