package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.junit.experimental.categories.Category;
import ru.naumkin.tm.api.endpoint.*;
import ru.naumkin.tm.enpoint.ProjectEndpointService;
import ru.naumkin.tm.enpoint.SessionEndpointService;
import ru.naumkin.tm.enpoint.UserEndpointService;

import java.util.List;

@Category(ProjectCrudTestCase.class)
public class ProjectCrudTest extends Assert {

    @NotNull
    private final IProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    @NotNull
    private final ISessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    
    @NotNull
    private User user = new User();

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
        @NotNull final Project project1 = new Project();
        project1.setUserId(userId);
        @NotNull final Project project2 = new Project();
        project2.setUserId(userId);
        @NotNull final Project project3 = new Project();
        project3.setUserId(userId);
        projectEndpoint.persistProject(sessionToken, project1);
        projectEndpoint.persistProject(sessionToken, project2);
        projectEndpoint.persistProject(sessionToken, project3);
        @NotNull final List<Project> projects = projectEndpoint.findAllProjectsByUserId(sessionToken);
        assertEquals(3, projects.size());
    }

    @Test
    public void findOneProjectByUserIdTest() throws Exception {
        @NotNull final Project toPersist = new Project();
        toPersist.setName("project");
        toPersist.setUserId(user.getId());
        projectEndpoint.persistProject(sessionToken, toPersist);
        @NotNull final String persistedProjectName = toPersist.getName();
        @NotNull final Project found =
                projectEndpoint.findOneProjectByUserId(sessionToken, toPersist.getName());
        @NotNull final String foundProjectName = found.getName();
        assertEquals(persistedProjectName, foundProjectName);
    }

    @Test
    public void persistProjectTest() throws Exception {
        @NotNull final Project toPersist = new Project();
        toPersist.setName("project");
        toPersist.setUserId(user.getId());
        projectEndpoint.persistProject(sessionToken, toPersist);
        @NotNull final String persistedProjectName = toPersist.getName();
        @NotNull final Project found =
                projectEndpoint.findOneProjectByUserId(sessionToken, toPersist.getName());
        @NotNull final String foundProjectName = found.getName();
        assertEquals(persistedProjectName, foundProjectName);
    }

    @Test
    public void mergeProjectTest() throws Exception {
        @NotNull final String name = "project";
        @NotNull final String description = "description";
        @NotNull Project project = new Project();
        project.setName(name);
        project.setUserId(userId);
        projectEndpoint.persistProject(sessionToken, project);
        project = projectEndpoint.findOneProjectByUserId(sessionToken, name);
        project.setDescription(description);
        projectEndpoint.mergeProject(sessionToken, project);
        @NotNull final Project mergedProject =
                projectEndpoint.findOneProjectByUserId(sessionToken, name);
        @NotNull final String mergedProjectDescription = mergedProject.getDescription();
        assertEquals(description, mergedProjectDescription);
    }

    @Test
    public void removeProjectByUserIdTest() throws Exception {
        @NotNull final String name = "project";
        @NotNull Project project = new Project();
        project.setName(name);
        project.setUserId(user.getId());
        projectEndpoint.persistProject(sessionToken, project);
        project = projectEndpoint.findOneProjectByUserId(sessionToken, name);
        projectEndpoint.removeProjectByUserId(sessionToken, project);
        @NotNull final List<Project> projects = projectEndpoint.findAllProjectsByUserId(sessionToken);
        assertEquals(0, projects.size());
    }

    @Test
    public void removeAllProjectsByUserIdTest() throws Exception {
        @NotNull final Project project1 = new Project();
        project1.setUserId(userId);
        @NotNull final Project project2 = new Project();
        project2.setUserId(userId);
        @NotNull final Project project3 = new Project();
        project3.setUserId(userId);
        projectEndpoint.persistProject(sessionToken, project1);
        projectEndpoint.persistProject(sessionToken, project2);
        projectEndpoint.persistProject(sessionToken, project3);
        projectEndpoint.removeAllProjectsByUserId(sessionToken);
        @NotNull final List<Project> projects = projectEndpoint.findAllProjectsByUserId(sessionToken);
        assertEquals(0, projects.size());
    }

}
