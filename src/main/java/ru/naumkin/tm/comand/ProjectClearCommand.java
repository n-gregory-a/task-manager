package ru.naumkin.tm.comand;

import ru.naumkin.tm.service.ProjectService;

public class ProjectClearCommand extends AbstractCommand {

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

        projectService.removeAll();
        bootstrap.getView().showMessage("[OK]");
    }

}
