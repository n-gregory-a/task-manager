package ru.naumkin.tm.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.service.IPropertyService;
import ru.naumkin.tm.api.service.IService;
import ru.naumkin.tm.entity.*;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public abstract class AbstractService<E extends AbstractEntity> implements IService<E> {

    @Getter
    @NotNull
    private IPropertyService propertyService;

    public AbstractService(@NotNull final IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @NotNull
    public EntityManagerFactory factory() {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, propertyService.getDriver());
        settings.put(Environment.URL, propertyService.getDbUrl());
        settings.put(Environment.USER, propertyService.getDbUserName());
        settings.put(Environment.PASS, propertyService.getDbPassword());
        settings.put(Environment.DIALECT, propertyService.getDbDialect());
        settings.put(Environment.HBM2DDL_AUTO, "none");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.FORMAT_SQL, "true");
        settings.put("hibernate.cache.use_second_level_cache", "true");
        settings.put("hibernate.cache.use_query_cache", "true");
        settings.put("hibernate.cache.use_minimal_puts", "true");
        settings.put("hibernate.cache.hazelcast.use_lite_member", "true");
        settings.put("hibernate.cache.region_prefix", "true");
        settings.put("hibernate.cache.provider_configuration_file_resource_path", "hazelcast.xml");
        settings.put("hibernate.cache.region.factory_class", "com.hazelcast.hibernate.HazelcastLocalCacheRegionFactory");

        final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings);
        final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Project.class);
        sources.addAnnotatedClass(Task.class);
        sources.addAnnotatedClass(User.class);
        sources.addAnnotatedClass(Session.class);
        final Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

}