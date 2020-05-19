package ru.naumkin.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IRepository;
import ru.naumkin.tm.api.service.*;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.SignatureUtil;

import java.util.LinkedList;
import java.util.List;

public class SessionService extends AbstractService<Session> implements ISessionService {

    @NotNull
    private final IProjectService projectService;

    @NotNull
    private final ITaskService taskService;

    @NotNull
    private final IUserService userService;

    @NotNull
    private final IPropertyService propertyService;

    public SessionService(
            @NotNull final IRepository<Session> repository,
            @NotNull final IProjectService projectService,
            @NotNull final ITaskService taskService,
            @NotNull final IUserService userService,
            @NotNull IPropertyService propertyService) {
        super(repository);
        this.projectService = projectService;
        this.taskService = taskService;
        this.userService = userService;
        this.propertyService = propertyService;
    }

    @NotNull
    @Override
    public Session open(@NotNull final String login, @NotNull final String password) {
        @NotNull Session session = new Session();
        session.setName("Session" + System.currentTimeMillis());
        session.setTimestamp(System.currentTimeMillis());
        @NotNull final User user = userService.findOne(login);
        final boolean passwordIsCorrect = password.equals(user.getPassword());
        if (!passwordIsCorrect) {
            throw new RuntimeException();
        }
        session.setUserId(user.getId());
        sign(session);
        repository.persist(session);
        return session;
    }

    @Override
    public void close(@NotNull final Session session) {
        repository.remove(session);
    }

    @Override
    public void closeAll(@NotNull final Session session) {
        repository.removeAll();
    }

    @NotNull
    @Override
    public List<Session> getListSession(@NotNull final Session session) {
        return new LinkedList<>(repository.findAll());
    }

    @Nullable
    @Override
    public User getUser(@NotNull final Session session) {
        @NotNull final String userId = session.getUserId();
        return userService.findOneById(userId);
    }

    @Override
    public void validate(@NotNull final Session session) {
        if (session.getUserId() == null || session.getUserId().isEmpty()) {
            throw new RuntimeException();
        }
        if (session.getSignature() == null || session.getSignature().isEmpty()) {
            throw new RuntimeException();
        }
        if (session.getTimestamp() == null) {
            throw new RuntimeException();
        }
        @Nullable final Session tempSession = session.clone();
        if (tempSession == null) {
            throw new RuntimeException();
        }
        @NotNull final String signatureSource = session.getSignature();
        tempSession.setSignature(null);
        @Nullable final String signatureTarget = sign(tempSession).getSignature();
        final boolean signatureEquals = signatureSource.equals(signatureTarget);
        if (!signatureEquals) {
            throw new RuntimeException();
        }
        final boolean sessionNotExists = repository.findOne(session.getName()) == null;
        if (sessionNotExists) {
            throw new RuntimeException();
        }
    }

    @Override
    public void validate(@NotNull final Session session, @NotNull final RoleType role) {
        validate(session);
        @Nullable final User sessionUser = getUser(session);
        if (sessionUser == null) {
            throw new RuntimeException();
        }
        final boolean roleIsAdmin = userService.isRoleAdmin(sessionUser);
        if (!roleIsAdmin) {
            throw new RuntimeException();
        }
    }

    @NotNull
    @Override
    public Session sign(@NotNull final Session session) {
        @NotNull final String salt = propertyService.getSessionSalt();
        @NotNull final Integer cycle = propertyService.getSessionCycle();
        @Nullable final String signature = SignatureUtil.sign(session, salt, cycle);
        if (signature != null) {
            session.setSignature(signature);
        }
        return session;
    }

    @Override
    public boolean isValid(@NotNull final Session session) {
        try {
            validate(session);
        } catch (RuntimeException e){
            return false;
        }
        return true;
    }

}
