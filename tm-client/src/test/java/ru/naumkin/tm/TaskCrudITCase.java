package ru.naumkin.tm;

import org.jetbrains.annotations.NotNull;
import org.junit.*;
import ru.naumkin.tm.api.endpoint.*;
import ru.naumkin.tm.enpoint.TaskEndpointService;
import ru.naumkin.tm.enpoint.SessionEndpointService;
import ru.naumkin.tm.enpoint.UserEndpointService;

import java.util.List;

public class TaskCrudITCase extends Assert {

    @NotNull
    private final ITaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();

    @NotNull
    private final ISessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    @NotNull
    private final IUserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    @NotNull
    private UserDTO user = new UserDTO();

    @NotNull
    private String sessionToken = "";

    @NotNull
    private String userId = "";

    @Before
    public void setUp() throws Exception {
        user = userEndpoint.findOneUser("test");
        sessionToken = sessionEndpoint.open(user.getName(), user.getPassword());
        userId = user.getId();
    }

    @After
    public void tearDown() throws Exception {
        taskEndpoint.removeAllTasksByUserId(sessionToken);
        sessionEndpoint.removeSession(sessionToken);
    }

    @Test
    public void findAllTasksByUserIdTest() throws Exception {
        @NotNull final TaskDTO task1 = new TaskDTO();
        task1.setUserId(userId);
        task1.setName("task1");
        @NotNull final TaskDTO task2 = new TaskDTO();
        task2.setUserId(userId);
        task2.setName("task2");
        @NotNull final TaskDTO task3 = new TaskDTO();
        task3.setUserId(userId);
        task3.setName("task3");
        taskEndpoint.persistTask(sessionToken, task1);
        taskEndpoint.persistTask(sessionToken, task2);
        taskEndpoint.persistTask(sessionToken, task3);
        @NotNull final List<TaskDTO> tasks = taskEndpoint.findAllTasksByUserId(sessionToken);
        assertEquals(3, tasks.size());
    }

    @Test
    public void findOneTaskByUserIdTest() throws Exception {
        @NotNull final TaskDTO toPersist = new TaskDTO();
        toPersist.setName("task");
        toPersist.setUserId(user.getId());
        taskEndpoint.persistTask(sessionToken, toPersist);
        @NotNull final String persistedTaskName = toPersist.getName();
        @NotNull final TaskDTO found =
                taskEndpoint.findOneTaskByUserId(sessionToken, toPersist.getName());
        @NotNull final String foundTaskName = found.getName();
        assertEquals(persistedTaskName, foundTaskName);
    }

    @Test
    public void persistTaskTest() throws Exception {
        @NotNull final TaskDTO toPersist = new TaskDTO();
        toPersist.setName("task");
        toPersist.setUserId(user.getId());
        taskEndpoint.persistTask(sessionToken, toPersist);
        @NotNull final String persistedTaskName = toPersist.getName();
        @NotNull final TaskDTO found =
                taskEndpoint.findOneTaskByUserId(sessionToken, toPersist.getName());
        @NotNull final String foundTaskName = found.getName();
        assertEquals(persistedTaskName, foundTaskName);
    }

    @Test
    public void mergeTaskTest() throws Exception {
        @NotNull final String name = "task";
        @NotNull final String description = "description";
        @NotNull TaskDTO task = new TaskDTO();
        task.setName(name);
        task.setUserId(userId);
        taskEndpoint.persistTask(sessionToken, task);
        task = taskEndpoint.findOneTaskByUserId(sessionToken, name);
        task.setDescription(description);
        taskEndpoint.mergeTask(sessionToken, task);
        @NotNull final TaskDTO mergedTask =
                taskEndpoint.findOneTaskByUserId(sessionToken, name);
        @NotNull final String mergedTaskDescription = mergedTask.getDescription();
        assertEquals(description, mergedTaskDescription);
    }

    @Test
    public void removeTaskByUserIdTest() throws Exception {
        @NotNull final String name = "task";
        @NotNull TaskDTO task = new TaskDTO();
        task.setName(name);
        task.setUserId(user.getId());
        taskEndpoint.persistTask(sessionToken, task);
        task = taskEndpoint.findOneTaskByUserId(sessionToken, name);
        taskEndpoint.removeTaskByUserId(sessionToken, task);
        @NotNull final List<TaskDTO> tasks = taskEndpoint.findAllTasksByUserId(sessionToken);
        assertEquals(0, tasks.size());
    }

    @Test
    public void removeAllTasksByUserIdTest() throws Exception {
        @NotNull final TaskDTO task1 = new TaskDTO();
        task1.setUserId(userId);
        task1.setName("task1");
        @NotNull final TaskDTO task2 = new TaskDTO();
        task2.setUserId(userId);
        task2.setName("task2");
        @NotNull final TaskDTO task3 = new TaskDTO();
        task3.setUserId(userId);
        task3.setName("task3");
        taskEndpoint.persistTask(sessionToken, task1);
        taskEndpoint.persistTask(sessionToken, task2);
        taskEndpoint.persistTask(sessionToken, task3);
        taskEndpoint.removeAllTasksByUserId(sessionToken);
        @NotNull final List<TaskDTO> tasks = taskEndpoint.findAllTasksByUserId(sessionToken);
        assertEquals(0, tasks.size());
    }
    
}
