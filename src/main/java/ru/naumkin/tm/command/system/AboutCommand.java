package ru.naumkin.tm.command.system;

import com.jcabi.manifests.Manifests;
import ru.naumkin.tm.command.AbstractCommand;

public final class AboutCommand extends AbstractCommand {

    public AboutCommand () {
        super(false);
    }

    @Override
    public String getName() {
        return "about";
    }

    @Override
    public String getDescription() {
        return "Show application information";
    }

    @Override
    public void execute() {
        String buildNumber = Manifests.read("buildNumber");
        String developer = Manifests.read("developer");
        String title = Manifests.read("Implementation-Title");
        serviceLocator.getTerminalService().showMessage("Title: " + title +
                "\nDeveloper: " + developer + "\nBuild number: " + buildNumber);
    }

}
