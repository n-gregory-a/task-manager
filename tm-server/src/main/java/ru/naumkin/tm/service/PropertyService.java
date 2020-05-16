package ru.naumkin.tm.service;

import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IPropertyService;

import java.io.InputStream;
import java.util.Properties;

public class PropertyService implements IPropertyService {

    @NotNull
    private final String PROPERTIES_FILE = "/application.properties";

    @NotNull private final Properties properties = new Properties();


    @Override
    public void init() throws Exception {
        @NotNull final InputStream inputStream =
                ProjectService.class.getResourceAsStream(PROPERTIES_FILE);
        properties.load(inputStream);
    }

    @NotNull
    @Override
    public String getServerHost() {
        return properties.getProperty("server.host");
    }

    @NotNull
    @Override
    public Integer getServerPort() {
        return Integer.parseInt(properties.getProperty("server.port"));
    }

    @NotNull
    @Override
    public Integer getSessionCycle() {
        return Integer.parseInt(properties.getProperty("session.cycle"));
    }

    @NotNull
    @Override
    public String getSessionSalt() {
        return properties.getProperty("session.salt");
    }

}
