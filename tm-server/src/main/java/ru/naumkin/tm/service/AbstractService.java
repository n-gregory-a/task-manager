package ru.naumkin.tm.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.entity.AbstractEntity;
import ru.naumkin.tm.repository.ProjectRepository;
import ru.naumkin.tm.repository.SessionRepository;
import ru.naumkin.tm.repository.TaskRepository;
import ru.naumkin.tm.repository.UserRepository;

import javax.sql.DataSource;

@NoArgsConstructor
public abstract class AbstractService<E extends AbstractEntity> implements IService<E> {

    @Getter
    @NotNull
    private IPropertyService propertyService;

    public AbstractService(@NotNull final IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @NotNull
    public SqlSessionFactory getSqlSessionFactory() {
        @NotNull final String driver = propertyService.getDriver();
        @NotNull final String url = propertyService.getDbUrl();
        @NotNull final String userName = propertyService.getDbUserName();
        @NotNull final String password = propertyService.getDbPassword();
        @NotNull final DataSource dataSource = new PooledDataSource(driver, url, userName, password);
        @NotNull final TransactionFactory transactionFactory = new JdbcTransactionFactory();
        @NotNull final Environment environment =
                new Environment("development", transactionFactory, dataSource);
        @NotNull final Configuration configuration = new Configuration(environment);
        configuration.addMapper(ProjectRepository.class);
        configuration.addMapper(SessionRepository.class);
        configuration.addMapper(TaskRepository.class);
        configuration.addMapper(UserRepository.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

}