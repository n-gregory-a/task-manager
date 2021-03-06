package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IPropertyService;

import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor
public final class PropertyService implements IPropertyService {

    @NotNull private final Properties properties = new Properties();

    @Override
    public void init() throws Exception {
        @NotNull String PROPERTIES_FILE = "/application.properties";
        @NotNull final InputStream inputStream =
                PropertyService.class.getResourceAsStream(PROPERTIES_FILE);
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

    @Override
    public @NotNull String getDriver() {
        return properties.getProperty("connection.driver");
    }

    @NotNull
    @Override
    public String getDbUrl() {
        return properties.getProperty("connection.url");
    }

    @NotNull
    @Override
    public String getDbUserName() {
        return properties.getProperty("connection.username");
    }

    @NotNull
    @Override
    public String getDbPassword() {
        return properties.getProperty("connection.password");
    }

    @Override
    public @NotNull String getDbDialect() {
        return properties.getProperty("connection.dialect");
    }

}
