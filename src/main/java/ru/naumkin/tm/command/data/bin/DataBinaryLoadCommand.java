package ru.naumkin.tm.command.data.bin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

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
        @NotNull final File file = new File(DataConstant.BINARY_FILE);
        @NotNull final FileInputStream fileInputStream = new FileInputStream(file);
        @NotNull final ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        loadProject(objectInputStream.readObject());
        loadTask(objectInputStream.readObject());
        objectInputStream.close();
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

    private void loadTask(@NotNull final Object object) {
        if (!(object instanceof Task[])) {
            return;
        }
        @NotNull final Task[] tasks = (Task[]) object;
        serviceLocator.getTaskService().load(tasks);
    }

    private void loadProject(@NotNull final Object object) {
        if (!(object instanceof Project[])) {
            return;
        }
        @NotNull final Project[] projects = (Project[]) object;
        serviceLocator.getProjectService().load(projects);
    }

    private void loadUser(@NotNull final Object object) {
        if (!(object instanceof User[])) {
            return;
        }
        @NotNull final User[] users = (User[]) object;
        for (User user: users) {
            if (serviceLocator.getUserService().isRoleAdmin(user)) {
                continue;
            }
            serviceLocator.getUserService().persist(user);
        }
    }

}
