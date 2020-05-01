package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.service.ProjectService;

public class ProjectClearCommand extends AbstractCommand {

    public ProjectClearCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-clear";
    }

    @Override
    public String getDescription() {
        return "Remove all projects.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[PROJECT CLEAR]");
        ProjectService projectService = bootstrap.getProjectService();
        projectService.removeAll(bootstrap.getCurrentUser().getID());
        bootstrap.getView().showMessage("[OK]");
    }

}
