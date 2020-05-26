package ru.naumkin.tm.service;

import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.repository.IUserRepository;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.error.*;

import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public final class UserService extends AbstractService<User> implements IUserService {

    public UserService(@NotNull IPropertyService propertyService) {
        super(propertyService);
    }

    @Override
    public boolean isRoleAdmin(@Nullable final String id) throws Exception {
        if (id == null) {
            throw new IdIsNullException();
        }
        if (id.isEmpty()) {
            throw new IdIsEmptyException();
        }
        @NotNull final User user = findOneById(id);
        return user.getRole() == RoleType.ADMINISTRATOR;
    }

    @NotNull
    @Override
    public List<User> findAll() throws Exception {
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        return userRepository.findAll();
    }

    @NotNull
    @Override
    public User findOne(@Nullable final String name) throws Exception {
        if (name == null) {
            throw new NameIsNullException();
        }
        if (name.isEmpty()) {
            throw new NameIsEmptyException();
        }
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        @Nullable final User user = userRepository.findOne(name);
        if (user == null) {
            throw new NoUserWithSuchLoginException(name);
        }
        return user;
    }

    @NotNull
    @Override
    public User findOneById(@Nullable final String id) throws Exception {
        if (id == null) {
            throw new IdIsNullException();
        }
        if (id.isEmpty()) {
            throw new IdIsEmptyException();
        }
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        @Nullable final User user = userRepository.findOneById(id);
        if (user == null) {
            throw new NoUserWithSuchIdException(id);
        }
        return user;
    }

    @Override
    public void persist(@Nullable final User user) throws Exception {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        try {
            userRepository.persist(user);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void merge(@Nullable final User user) throws Exception {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        try {
            userRepository.merge(user);
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void remove(@Nullable final User user) throws Exception {
        if (user == null) {
            throw new UserIsNullException();
        }
        @NotNull final SqlSession sqlSession = getSqlSessionFactory().openSession();
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        try {
            userRepository.remove(user);
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
        @NotNull final IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
        try {
            userRepository.removeAll();
            sqlSession.commit();
        } catch (SQLException e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

}
