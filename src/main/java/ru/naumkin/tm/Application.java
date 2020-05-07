package ru.naumkin.tm;

import ru.naumkin.tm.command.project.*;
import ru.naumkin.tm.command.system.AboutCommand;
import ru.naumkin.tm.command.system.ExitCommand;
import ru.naumkin.tm.command.system.HelpCommand;
import ru.naumkin.tm.command.task.*;
import ru.naumkin.tm.command.user.*;
import ru.naumkin.tm.context.Bootstrap;

public final class Application {

    public static void main(String[] args) throws Exception {
        final Bootstrap bootstrap = new Bootstrap();
        final Class[] classes = new Class[] {
                HelpCommand.class,
                ProjectClearCommand.class,
                ProjectCreateCommand.class,
                ProjectListCommand.class,
                ProjectReadCommand.class,
                ProjectRemoveCommand.class,
                ProjectUpdateCommand.class,
                TaskAttachCommand.class,
                TaskClearCommand.class,
                TaskCreateCommand.class,
                TaskListCommand.class,
                TaskReadCommand.class,
                TaskRemoveCommand.class,
                TaskUpdateCommand.class,
                TaskViewCommand.class,
                ExitCommand.class,
                UserChangePasswordCommand.class,
                UserLogInCommand.class,
                UserLogOutCommand.class,
                UserReadCommand.class,
                UserRegisterCommand.class,
                UserUpdateCommand.class,
                AboutCommand.class
        };
        bootstrap.init(classes);
    }

}
