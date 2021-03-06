package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.junit.rules.ExpectedException;
import ru.naumkin.tm.api.endpoint.ISessionEndpoint;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.endpoint.UserDTO;
import ru.naumkin.tm.enpoint.SessionEndpointService;
import ru.naumkin.tm.enpoint.UserEndpointService;

import java.util.List;

public class UserCrudITCase extends Assert {

    @NotNull
    private final ISessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    @NotNull
    private String sessionToken = "";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        @NotNull final UserDTO test = userEndpoint.findOneUser("test");
        sessionToken = sessionEndpoint.open(test.getName(), test.getPassword());
    }

    @After
    public void tearDown() throws Exception {
        @NotNull UserDTO testUser = new UserDTO();
        try {
            testUser = userEndpoint.findOneUser("testUser");
        } catch (Exception e) {
            testUser.setName("testUser");
            userEndpoint.persistUser(testUser);
        }
        testUser = userEndpoint.findOneUser("testUser");
        userEndpoint.removeUser(sessionToken, testUser);
        sessionEndpoint.removeSession(sessionToken);
    }

    @Test
    public void findAllUsersTest() throws Exception {
        @NotNull final List<UserDTO> users = userEndpoint.findAllUsers();
        assertTrue(users.size() >= 1);
    }

    @Test
    public void findOneUserTest() throws Exception {
        @NotNull final UserDTO user = userEndpoint.findOneUser("test");
        assertEquals("test", user.getName());
    }

    @Test
    public void persistUserTest() throws Exception {
        @NotNull final UserDTO testUser = new UserDTO();
        testUser.setName("testUser");
        userEndpoint.persistUser(testUser);
        @NotNull final UserDTO user = userEndpoint.findOneUser("testUser");
        assertEquals("testUser", user.getName());
    }

    @Test
    public void removeUserTest() throws Exception {
        @NotNull UserDTO testUser = new UserDTO();
        testUser.setName("testUser");
        userEndpoint.persistUser(testUser);
        testUser = userEndpoint.findOneUser("testUser");
        userEndpoint.removeUser(sessionToken, testUser);
        expectedException.expect(Exception.class);
        expectedException.expectMessage("No user with login testUser.");
        testUser = userEndpoint.findOneUser("testUser");
    }

}
