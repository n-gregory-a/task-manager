package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;
import ru.naumkin.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface IProjectEndpoint {

    @Nullable
    @WebMethod
    Project persistProject(@NotNull final Session session,
                           @NotNull final Project project) throws SQLException;

    @Nullable
    @WebMethod
    Project mergeProject(@NotNull final Session session,
                         @NotNull final Project project,
                         @NotNull final String name) throws SQLException;

    @NotNull
    @WebMethod
    List<Project> findAllProjectsByUserId(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    Project findOneProjectByUserId(@NotNull final Session session,
                                   @NotNull final String name) throws SQLException;

    @NotNull
    @WebMethod
    Project removeProjectByUserId(@NotNull final Session session,
                                  @NotNull final Project project) throws SQLException;

    @WebMethod
    void removeAllProjectsByUserId(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateStart(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDateFinish(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByStatus(@NotNull final Session session) throws SQLException;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByName(@NotNull final Session session,
                                     @NotNull final String name) throws SQLException;

    @NotNull
    @WebMethod
    List<Project> sortProjectsByDescription(@NotNull final Session session,
                                            @NotNull final String description) throws SQLException;

}
