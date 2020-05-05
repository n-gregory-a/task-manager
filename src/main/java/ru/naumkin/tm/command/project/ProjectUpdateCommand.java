package ru.naumkin.tm.command.project;

import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.ProjectIsNullException;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.util.DateFormatter;

import java.util.ArrayList;
import java.util.List;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand() {
        super(true);
    }

    @Override
    public String getName() {
        return "project-update";
    }

    @Override
    public String getDescription() {
        return "Update selected project.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getTerminalService().showMessage("[PROJECT UPDATE]");
        ProjectService projectService = bootstrap.getProjectService();
        bootstrap.getTerminalService().showMessage("Projects available to update:");
        List<Project> list = new ArrayList<>();
        int index = 1;
        String currentUserId = bootstrap.getCurrentUser().getId();
        for (Project project: projectService.findAll(currentUserId)) {
            bootstrap.getTerminalService().showMessage(index++ + ". " + project.toString());
            list.add(project);
        }
        bootstrap.getTerminalService().showMessage("Choose project to update by number:");
        Project project = list.get(Integer.parseInt(bootstrap.getTerminalService().readLine()) - 1);
        String name = project.getName();
        bootstrap.getTerminalService().showMessage("Updating project:");
        bootstrap.getTerminalService().showMessage("id: " + project.getId() +
                ", name: " + project.getName());
        bootstrap.getTerminalService().showMessage("Enter new name:");
        project.setName(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new description:");
        project.setDescription(bootstrap.getTerminalService().readLine());
        bootstrap.getTerminalService().showMessage("Enter new start date(dd.mm.yyyy):");
        project.setDateStart(DateFormatter.convertStringToDate(bootstrap.getTerminalService().readLine()));
        bootstrap.getTerminalService().showMessage("Enter new finish date(dd.mm.yyyy):");
        project.setDateFinish(DateFormatter.convertStringToDate(bootstrap.getTerminalService().readLine()));
        try {
            projectService.merge(project, name);
        } catch (NameIsEmptyException | ProjectIsNullException e) {
            bootstrap.getTerminalService().showMessage(e.toString());
            return;
        }
        bootstrap.getTerminalService().showMessage("[OK]");
    }

}
