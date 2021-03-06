package ru.naumkin.tm.util;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {

    @NotNull
    public static Connection getConnection(
            @NotNull final String driver,
            @NotNull final String url,
            @NotNull final String userName,
            @NotNull final String password
    ) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url, userName, password);
    }

}
