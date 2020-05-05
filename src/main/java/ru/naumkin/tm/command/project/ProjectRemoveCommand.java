package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.NoProjectWithSuchNameException;
import ru.naumkin.tm.error.ProjectIsNullException;
import ru.naumkin.tm.service.ProjectService;

public class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-remove";
    }

    @Override
    public String getDescription() {
        return "Remove selected project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT REMOVE]");
        ProjectService projectService = bootstrap.getProjectService();
        String currentUserId = bootstrap.getCurrentUser().getId();
        if (projectService.findAll(currentUserId).isEmpty()) {
            bootstrap.getTerminalService().showMessage("[Project list is empty.]");
            return;
        }
        Project project;
        bootstrap.getTerminalService().showMessage("Enter project name:");
        String projectName = bootstrap.getTerminalService().readLine();
        try {
            project = projectService.findOne(projectName, currentUserId);
        } catch (NameIsEmptyException |
                NoProjectWithSuchNameException |
                ProjectIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            return;
        }
        try {
            projectService.remove(project, currentUserId);
        } catch (ProjectIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
        }
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
