package ru.naumkin.tm.command.data.bin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IProjectService;
import ru.naumkin.tm.api.service.ITaskService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.command.AbstractCommand;
import ru.naumkin.tm.constant.DataConstant;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Task;
import ru.naumkin.tm.entity.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

public class DataBinarySaveCommand extends AbstractCommand {

    public DataBinarySaveCommand() {
        super(true);
    }

    @Override
    public @Nullable String getName() {
        return "data-bin-save";
    }

    @Override
    public @Nullable String getDescription() {
        return "Save data to binary file.";
    }

    @Override
    public void execute() throws Exception {
        serviceLocator.getTerminalService().showMessage("[SAVE DATA TO BINARY FILE]");
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        @NotNull final IUserService userService = serviceLocator.getUserService();
        @NotNull final Project[] projects = projectService.findAll().toArray(new Project[0]);
        @NotNull final Task[] tasks = taskService.findAll().toArray(new Task[0]);
        @NotNull final User[] users = userService.findAll().toArray(new User[0]);
        @NotNull final File file = new File(DataConstant.BINARY_FILE);
        Files.deleteIfExists(file.toPath());
        Files.createFile(file.toPath());
        @NotNull final FileOutputStream fileOutputStream = new FileOutputStream(file);
        @NotNull final ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projects);
        objectOutputStream.writeObject(tasks);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
        serviceLocator.getTerminalService().showMessage("[OK]");
    }

}
