package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.ISessionRepository;
import ru.naumkin.tm.api.repository.IUserRepository;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.ISessionService;
import ru.naumkin.tm.constant.ValidationConstant;
import ru.naumkin.tm.entity.Session;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.error.*;
import ru.naumkin.tm.util.SignatureUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class SessionService extends AbstractService<Session> implements ISessionService {

    public SessionService(@NotNull final IPropertyService propertyService) {
        super(propertyService);
    }

    @NotNull
    @Override
    public List<Session> findAll() throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        return sessionRepository.findAll();
    }

    @Nullable
    @Override
    public Session findOne(@NotNull final String id) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        return sessionRepository.findOne(id);
    }

    @Override
    public void persist(@NotNull final Session session) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        try {
            sessionRepository.persist(session);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void merge(@NotNull final Session session) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        try {
            sessionRepository.merge(session);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void remove(@NotNull final Session session) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        try {
            sessionRepository.remove(session);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeAll() throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        try {
            sessionRepository.removeAll();
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

    @NotNull
    @Override
    public Session open(@NotNull final String login, @NotNull final String password) throws Exception {
        @NotNull Session session = new Session();
        session.setName("Session" + System.currentTimeMillis());
        session.setTimestamp(System.currentTimeMillis());
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        @Nullable final User user = userRepository.findOne(login);
        if (user == null) {
            throw new UserIsNullException();
        }
        final boolean passwordIsCorrect = password.equals(user.getPassword());
        if (!passwordIsCorrect) {
            throw new PasswordIsIncorrectException();
        }
        session.setUserId(user.getId());
        sign(session);
        persist(session);
        return session;
    }

    @Override
    public void close(@NotNull final Session session) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        sessionRepository.remove(session);
    }

    @Override
    public void closeAll(@NotNull final Session session) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        sessionRepository.removeAll();
    }

    @NotNull
    @Override
    public List<Session> getListSession(@NotNull final Session session) throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        return sessionRepository.findAll();
    }

    @Nullable
    @Override
    public User getUser(@NotNull final Session session) throws Exception {
        @NotNull final String userId = session.getUserId();
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        return userRepository.findOneById(userId);
    }

    @Override
    public void validate(@NotNull final Session session) throws Exception {
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
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final ISessionRepository sessionRepository = sqlSession.getMapper(ISessionRepository.class);
        final boolean sessionNotExists =
                sessionRepository.findOne(session.getId()) == null;
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
