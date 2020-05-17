package ru.naumkin.tm.command.system;

import com.jcabi.manifests.Manifests;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.command.AbstractCommand;

public final class AboutCommand extends AbstractCommand {

    public AboutCommand () {
        super(false);
    }

    @NotNull
    @Override
    public String getName() {
        return "about";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Show application information";
    }

    @Override
    public void execute() {
        @Nullable final String buildNumber = Manifests.read("buildNumber");
        @Nullable final String developer = Manifests.read("developer");
        @Nullable final String title = Manifests.read("Implementation-Title");
        bootstrap.getTerminalService().showMessage("Title: " + title +
                "\nDeveloper: " + developer + "\nBuild number: " + buildNumber);
    }

}
