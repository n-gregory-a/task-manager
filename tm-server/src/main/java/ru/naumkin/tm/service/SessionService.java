package ru.naumkin.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.constant.ValidationConstant;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.repository.SessionRepository;
import ru.naumkin.tm.repository.UserRepository;
import ru.naumkin.tm.util.SignatureUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SessionService extends AbstractService<Session> implements ISessionService {

    public SessionService(@NotNull final IPropertyService propertyService) {
        super(propertyService);
    }

    @NotNull
    @Override
    public List<Session> findAll() throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new SessionRepository(connection).findAll();
    }

    @Nullable
    @Override
    public Session findOne(@NotNull final String id) throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new SessionRepository(connection).findOne(id);
    }

    @Nullable
    @Override
    public Session persist(@NotNull final Session session) throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new SessionRepository(connection).persist(session);
    }

    @Nullable
    @Override
    public Session merge(@NotNull final Session session) throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new SessionRepository(connection).merge(session);
    }

    @Nullable
    @Override
    public Session remove(@NotNull final Session session) throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new SessionRepository(connection).remove(session);
    }

    @Override
    public void removeAll() throws SQLException {
        @NotNull final Connection connection = getConnection();
        new SessionRepository(connection).removeAll();
    }

    @NotNull
    @Override
    public Session open(@NotNull final String login, @NotNull final String password) throws SQLException {
        @NotNull Session session = new Session();
        session.setName("Session" + System.currentTimeMillis());
        session.setTimestamp(System.currentTimeMillis());
        @NotNull final Connection userFindConnection = getConnection();
        @Nullable final User user = new UserRepository(userFindConnection).findOne(login);
        if (user == null) {
            throw new UserIsNullException();
        }
        final boolean passwordIsCorrect = password.equals(user.getPassword());
        if (!passwordIsCorrect) {
            throw new PasswordIsIncorrectException();
        }
        session.setUserId(user.getId());
        sign(session);
        @NotNull final Connection sessionPersistConnection = getConnection();
        new SessionRepository(sessionPersistConnection).persist(session);
        return session;
    }

    @Override
    public void close(@NotNull final Session session) throws SQLException {
        @NotNull final Connection connection = getConnection();
        new SessionRepository(connection).remove(session);
    }

    @Override
    public void closeAll(@NotNull final Session session) throws SQLException {
        @NotNull final Connection connection = getConnection();
        new SessionRepository(connection).removeAll();
    }

    @NotNull
    @Override
    public List<Session> getListSession(@NotNull final Session session) throws SQLException {
        @NotNull final Connection connection = getConnection();
        return new SessionRepository(connection).findAll();
    }

    @Nullable
    @Override
    public User getUser(@NotNull final Session session) throws SQLException {
        @NotNull final String userId = session.getUserId();
        @NotNull final Connection connection = getConnection();
        return new UserRepository(connection).findOneById(userId);
    }

    @Override
    public void validate(@NotNull final Session session) throws SQLException {
        if (session.getUserId() == null || session.getUserId().isEmpty()) {
            throw new SessionValidationException();
        }
        if (session.getSignature() == null || session.getSignature().isEmpty()) {
            throw new SessionValidationException();
        }
        if (session.getTimestamp() == null) {
            throw new SessionValidationException();
        }
        @Nullable final Session tempSession = session.clone();
        if (tempSession == null) {
            throw new SessionIsNullException();
        }
        @NotNull final String signatureSource = session.getSignature();
        tempSession.setSignature(null);
        @Nullable final String signatureTarget = sign(tempSession).getSignature();
        final boolean signatureEquals = signatureSource.equals(signatureTarget);
        if (!signatureEquals) {
            throw new SessionValidationException();
        }
        @NotNull final Connection connection = getConnection();
        final boolean sessionNotExists =
                new SessionRepository(connection).findOne(session.getId()) == null;
        if (sessionNotExists) {
            throw new SessionIsNullException();
        }
        final long now = new Date().getTime();
        final boolean timeIsOut = now - session.getTimestamp() > ValidationConstant.SESSION_TIME_OUT;
        if (timeIsOut) {
            throw new SessionTimeOutException();
        }
    }

    @NotNull
    @Override
    public Session sign(@NotNull final Session session) {
        @NotNull final String salt = getPropertyService().getSessionSalt();
        @NotNull final Integer cycle = getPropertyService().getSessionCycle();
        @Nullable final String signature = SignatureUtil.sign(session, salt, cycle);
        if (signature != null) {
            session.setSignature(signature);
        }
        return session;
    }

}
