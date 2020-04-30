package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.error.NameIsEmptyException;
import ru.naumkin.tm.error.ProjectIsNullException;
import ru.naumkin.tm.service.ProjectService;
import ru.naumkin.tm.util.DateFormatter;

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
        bootstrap.getView().showMessage("[PROJECT UPDATE]");
        ProjectService projectService = bootstrap.getProjectService();
        bootstrap.getView().showMessage("Enter project name:");
        Project project = new Project(bootstrap.getView().readLine());
        String name = project.getName();
        bootstrap.getView().showMessage("Enter new name:");
        project.setName(bootstrap.getView().readLine());
        bootstrap.getView().showMessage("Enter new description:");
        project.setDescription(bootstrap.getView().readLine());
        bootstrap.getView().showMessage("Enter new start date(dd.mm.yyyy):");
        project.setDateStart(DateFormatter.convertStringToDate(bootstrap.getView().readLine()));
        bootstrap.getView().showMessage("Enter new finish date(dd.mm.yyyy):");
        project.setDateFinish(DateFormatter.convertStringToDate(bootstrap.getView().readLine()));
        try {
            projectService.merge(project, name);
        } catch (NameIsEmptyException | ProjectIsNullException e) {
            bootstrap.getView().showMessage(e.toString());
            return;
        }
        bootstrap.getView().showMessage("[OK]");
    }

}
