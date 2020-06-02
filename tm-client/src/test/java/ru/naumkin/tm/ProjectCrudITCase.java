package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.naumkin.tm.api.endpoint.*;
import ru.naumkin.tm.enpoint.ProjectEndpointService;
import ru.naumkin.tm.enpoint.SessionEndpointService;
import ru.naumkin.tm.enpoint.UserEndpointService;

import java.util.List;

public class ProjectCrudITCase extends Assert {

    @NotNull
    private final IProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    @NotNull
    private final ISessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    
    @NotNull
    private UserDTO user = new UserDTO();

    @NotNull
    private String sessionToken = "";

    @NotNull
    private static String userId = "";

    @Before
    public void setUp() throws Exception {
        user = userEndpoint.findOneUser("test");
        sessionToken = sessionEndpoint.open(user.getName(), user.getPassword());
        userId = user.getId();
    }

    @After
    public void tearDown() throws Exception {
        projectEndpoint.removeAllProjectsByUserId(sessionToken);
        sessionEndpoint.removeSession(sessionToken);
    }

    @Test
    public void findAllProjectsByUserIdTest() throws Exception {
        @NotNull final ProjectDTO project1 = new ProjectDTO();
        project1.setUserId(userId);
        project1.setName("p1");
        @NotNull final ProjectDTO project2 = new ProjectDTO();
        project2.setUserId(userId);
        project2.setName("p2");
        @NotNull final ProjectDTO project3 = new ProjectDTO();
        project3.setUserId(userId);
        project3.setName("p3");
        projectEndpoint.persistProject(sessionToken, project1);
        projectEndpoint.persistProject(sessionToken, project2);
        projectEndpoint.persistProject(sessionToken, project3);
        @NotNull final List<ProjectDTO> projects = projectEndpoint.findAllProjectsByUserId(sessionToken);
        assertEquals(3, projects.size());
    }

    @Test
    public void findOneProjectByUserIdTest() throws Exception {
        @NotNull final ProjectDTO toPersist = new ProjectDTO();
        toPersist.setName("project");
        toPersist.setUserId(user.getId());
        projectEndpoint.persistProject(sessionToken, toPersist);
        @NotNull final String persistedProjectName = toPersist.getName();
        @NotNull final ProjectDTO found =
                projectEndpoint.findOneProjectByUserId(sessionToken, toPersist.getName());
        @NotNull final String foundProjectName = found.getName();
        assertEquals(persistedProjectName, foundProjectName);
    }

    @Test
    public void persistProjectTest() throws Exception {
        @NotNull final ProjectDTO toPersist = new ProjectDTO();
        toPersist.setName("project");
        toPersist.setUserId(user.getId());
        projectEndpoint.persistProject(sessionToken, toPersist);
        @NotNull final String persistedProjectName = toPersist.getName();
        @NotNull final ProjectDTO found =
                projectEndpoint.findOneProjectByUserId(sessionToken, toPersist.getName());
        @NotNull final String foundProjectName = found.getName();
        assertEquals(persistedProjectName, foundProjectName);
    }

    @Test
    public void mergeProjectTest() throws Exception {
        @NotNull final String name = "project";
        @NotNull final String description = "description";
        @NotNull ProjectDTO project = new ProjectDTO();
        project.setName(name);
        project.setUserId(userId);
        projectEndpoint.persistProject(sessionToken, project);
        project = projectEndpoint.findOneProjectByUserId(sessionToken, name);
        project.setDescription(description);
        projectEndpoint.mergeProject(sessionToken, project);
        @NotNull final ProjectDTO mergedProject =
                projectEndpoint.findOneProjectByUserId(sessionToken, name);
        @NotNull final String mergedProjectDescription = mergedProject.getDescription();
        assertEquals(description, mergedProjectDescription);
    }

    @Test
    public void removeProjectByUserIdTest() throws Exception {
        @NotNull final String name = "project";
        @NotNull ProjectDTO project = new ProjectDTO();
        project.setName(name);
        project.setUserId(user.getId());
        projectEndpoint.persistProject(sessionToken, project);
        project = projectEndpoint.findOneProjectByUserId(sessionToken, name);
        projectEndpoint.removeProjectByUserId(sessionToken, project);
        @NotNull final List<ProjectDTO> projects = projectEndpoint.findAllProjectsByUserId(sessionToken);
        assertEquals(0, projects.size());
    }

    @Test
    public void removeAllProjectsByUserIdTest() throws Exception {
        @NotNull final ProjectDTO project1 = new ProjectDTO();
        project1.setUserId(userId);
        project1.setName("p1");
        @NotNull final ProjectDTO project2 = new ProjectDTO();
        project2.setUserId(userId);
        project2.setName("p2");
        @NotNull final ProjectDTO project3 = new ProjectDTO();
        project3.setUserId(userId);
        project3.setName("p3");
        projectEndpoint.persistProject(sessionToken, project1);
        projectEndpoint.persistProject(sessionToken, project2);
        projectEndpoint.persistProject(sessionToken, project3);
        projectEndpoint.removeAllProjectsByUserId(sessionToken);
        @NotNull final List<ProjectDTO> projects =
                projectEndpoint.findAllProjectsByUserId(sessionToken);
        assertEquals(0, projects.size());
    }

}
