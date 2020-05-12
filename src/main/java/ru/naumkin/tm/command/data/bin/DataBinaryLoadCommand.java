package ru.naumkin.tm.command.data.bin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;

import java.io.*;

public class DataBinaryLoadCommand extends AbstractCommand {

    public DataBinaryLoadCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-bin-load";
    }

    @Override
    public @Nullable String getDescription() {
        return "Load data from binary file.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[LOAD DATA FROM BINARY FILE]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull final File file = new File(DataConstant.BINARY_FILE);
        @NotNull final FileInputStream fileInputStream = new FileInputStream(file);
        @NotNull final ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        loadProjects(objectInputStream.readObject());
        loadTasks(objectInputStream.readObject());
        objectInputStream.close();
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    private void loadTasks(Object object) {
        if (!(object instanceof Task[])) {
            return;
        }
        final Task[] tasks = (Task[]) object;
        serviceLocator.getTaskService().load(tasks);
    }

    private void loadProjects(final Object object) {
        if (!(object instanceof Project[])) {
            return;
        }
        final Project[] projects = (Project[]) object;
        serviceLocator.getProjectService().load(projects);
    }

}
