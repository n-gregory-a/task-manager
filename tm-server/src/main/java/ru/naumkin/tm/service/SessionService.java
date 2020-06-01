package ru.naumkin.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
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

import javax.persistence.EntityManager;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public final class SessionService extends AbstractService<Session> implements ISessionService {

    @NotNull
    private ISessionRepository sessionRepository;

    @NotNull
    private IUserRepository userRepository;

    public SessionService(
            @NotNull final IPropertyService propertyService,
            @NotNull final ISessionRepository sessionRepository,
            @NotNull final IUserRepository userRepository
    ) {
        super(propertyService);
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    @NotNull
    @Override
    public List<Session> findAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @NotNull final List<Session> sessions = sessionRepository.findAll();
        entityManager.getTransaction().commit();
        return sessions;
    }

    @NotNull
    @Override
    public Session findOne(@NotNull final String id) {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        @Nullable final Session session = sessionRepository.findOne(id);
        if (session == null) {
            throw new SessionIsNullException();
        }
        return session;
    }

    @Override
    public void persist(@NotNull final String sessionToken) throws Exception {
        @NotNull final Session session = getSessionFromToken(sessionToken);
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        sessionRepository.persist(session);
        entityManager.getTransaction().commit();
    }

    @Override
    public void merge(@NotNull final String sessionToken) throws Exception {
        @NotNull final Session session = getSessionFromToken(sessionToken);
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        sessionRepository.merge(session);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(@NotNull final String sessionToken) throws Exception {
        @NotNull final Session session = getSessionFromToken(sessionToken);
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        sessionRepository.remove(session.getId());
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeAll() {
        @NotNull final EntityManager entityManager = factory().createEntityManager();
        entityManager.getTransaction().begin();
        sessionRepository.removeAll();
        entityManager.getTransaction().commit();
    }

    @NotNull
    @Override
    public String open(@NotNull final String login, @NotNull final String password) throws Exception {
        @NotNull Session session = new Session();
        session.setName("Session" + System.currentTimeMillis());
        session.setTimestamp(System.currentTimeMillis());
        @Nullable final User user = userRepository.findOne(login);
        if (user == null) {
            throw new UserIsNullException();
        }
        final boolean passwordIsCorrect = password.equals(user.getPassword());
        if (!passwordIsCorrect) {
            throw new PasswordIsIncorrectException();
        }
        session.setUser(user);
        sign(session);
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final String json = objectMapper.writeValueAsString(session);
        @NotNull final String salt = getPropertyService().getSessionSalt();
        @NotNull final String saltedJson = salt + json + salt;
        @NotNull final String sessionToken = Base64.getEncoder().encodeToString(saltedJson.getBytes());
        persist(sessionToken);
        return sessionToken;
    }

    @NotNull
    @Override
    public String getUserId(@NotNull final String sessionToken) throws Exception {
        @NotNull final Session session = getSessionFromToken(sessionToken);
        return session.getUser().getId();
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
    private Session sign(@NotNull final Session session) {
        @NotNull final String salt = getPropertyService().getSessionSalt();
        @NotNull final Integer cycle = getPropertyService().getSessionCycle();
        @Nullable final String signature = SignatureUtil.sign(session, salt, cycle);
        if (signature != null) {
            session.setSignature(signature);
        }
        return session;
    }

}
