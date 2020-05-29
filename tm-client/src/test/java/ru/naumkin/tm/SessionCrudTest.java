package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.junit.rules.ExpectedException;
import ru.naumkin.tm.api.endpoint.ISessionEndpoint;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.endpoint.Session;
import ru.naumkin.tm.api.endpoint.User;
import ru.naumkin.tm.enpoint.SessionEndpointService;
import ru.naumkin.tm.enpoint.UserEndpointService;

import java.util.List;

public class SessionCrudTest extends Assert {

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
        @NotNull final User test = userEndpoint.findOneUser("test");
        sessionToken = sessionEndpoint.open(test.getName(), test.getPassword());
    }

    @After
    public void tearDown() throws Exception {
        sessionEndpoint.removeAllSessions(sessionToken);
    }

    @Test
    public void findAllSessionsTest() throws Exception {
        @NotNull final List<Session> sessions = sessionEndpoint.findAllSessions(sessionToken);
        assertTrue(sessions.size() != 0);
    }

    @Test
    public void findOneSessionTest() throws Exception {
        @NotNull final List<Session> sessions = sessionEndpoint.findAllSessions(sessionToken);
        @NotNull Session session = sessions.get(0);
        @NotNull final String sessionId= session.getId();
        @NotNull final Session testSession = sessionEndpoint.findOneSession(sessionToken, sessionId);
        assertEquals(sessionId, testSession.getId());
    }

    @Test
    public void persistSessionTest() throws Exception {
        @NotNull final User test = userEndpoint.findOneUser("user");
        @NotNull List<Session> sessions = sessionEndpoint.findAllSessions(sessionToken);
        final int numberOfSessionsBefore = sessions.size();
        @NotNull final String testSessionToken = sessionEndpoint.open(test.getName(), test.getPassword());
        sessions = sessionEndpoint.findAllSessions(sessionToken);
        final int numberOfSessionAfter = sessions.size();
        assertTrue(numberOfSessionsBefore < numberOfSessionAfter);
    }

    @Test
    public void removeSessionTest() throws Exception {
        @NotNull final User test = userEndpoint.findOneUser("user");
        @NotNull final String testSessionToken = sessionEndpoint.open(test.getName(), test.getPassword());
        @NotNull List<Session> sessions = sessionEndpoint.findAllSessions(sessionToken);
        final int numberOfSessionsBefore = sessions.size();
        sessionEndpoint.removeSession(testSessionToken);
        sessions = sessionEndpoint.findAllSessions(sessionToken);
        final int numberOfSessionAfter = sessions.size();
        assertTrue(numberOfSessionsBefore > numberOfSessionAfter);
    }

    @Test
    public void removeAllSessionsTest() throws Exception {
        sessionEndpoint.removeAllSessions(sessionToken);
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Session does not exist.");
        sessionEndpoint.findAllSessions(sessionToken);
    }

}
