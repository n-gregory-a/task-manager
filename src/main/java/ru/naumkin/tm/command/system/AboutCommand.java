package ru.naumkin.tm.command.system;

import ru.naumkin.tm.command.AbstractCommand;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

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
    public void execute() throws IOException {
        Manifest manifest = new JarFile("target/task-manager-1.0.0.jar").getManifest();

        Attributes attributes = manifest.getMainAttributes();
        String title = attributes.getValue("Implementation-Title");
        String buildNumber = attributes.getValue("buildNumber");
        String developer = attributes.getValue("developer");
        serviceLocator.getTerminalService().showMessage("Title: " + title +
                "\nDeveloper: " + developer + "\nBuild number: " + buildNumber);
    }

}
