package ru.naumkin.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Base64;
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
            sessionRepository.remove(session.getId());
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
    public String open(@NotNull final String login, @NotNull final String password) throws Exception {
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
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final String json = objectMapper.writeValueAsString(session);
        @NotNull final String salt = getPropertyService().getSessionSalt();
        @NotNull final String saltedJson = salt + json + salt;
        @NotNull final String sessionToken = Base64.getEncoder().encodeToString(saltedJson.getBytes());
        return sessionToken;
    }

    @NotNull
    @Override
    public String getUserId(@NotNull final String sessionToken) throws Exception {
        @NotNull final Session session = getSessionFromToken(sessionToken);
        return session.getUserId();
    }

    @Override
    public void validate(@NotNull final String sessionToken) throws Exception {
        if (sessionToken.isEmpty()) {
            throw new SessionTokenIsEmptyException();
        }
        @NotNull final Session session = getSessionFromToken(sessionToken);
        if (session.getSignature() == null || session.getSignature().isEmpty()) {
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
    private Session getSessionFromToken(@NotNull final String sessionToken) throws com.fasterxml.jackson.core.JsonProcessingException {
        byte[] decodedBytes = Base64.getDecoder().decode(sessionToken);
        @NotNull final String saltedJson = new String(decodedBytes);
        @NotNull final String json = saltedJson.replace(getPropertyService().getSessionSalt(), "");
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Session.class);
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
