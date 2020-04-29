package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.service.ProjectService;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-list";
    }

    @Override
    public String getDescription() {
        return "Show all projects.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[PROJECT LIST]");

        ProjectService projectService = bootstrap.getProjectService();

        int index = 1;
        for (Project project: projectService.findAll()) {
            bootstrap.getView().showMessage(index++ + ". " + project.toString());
        }
    }

}
