package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
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
        bootstrap.getTerminalService().showMessage("[PROJECT LIST]");
        ProjectService projectService = bootstrap.getProjectService();
        int index = 1;
        String currentUserId = bootstrap.getCurrentUser().getId();
        for (Project project: projectService.findAll(currentUserId)) {
            bootstrap.getTerminalService().showMessage(index++ + ". " + project.toString());
        }
    }

}
