package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;

import java.util.List;

public interface IUserRepository {

    @NotNull
    @Select("SELECT * FROM `app_user`")
    List<User> findAll() throws Exception;

    @Nullable
    @Select("SELECT * FROM `app_user` " +
            "WHERE `name` = #{name}")
    User findOne(@NotNull final String name) throws Exception;

    @Nullable
    @Select("SELECT * FROM `app_user` " +
            "WHERE `id` = #{id}")
    User findOneById(@NotNull final String id) throws Exception;

    @Nullable
    @Insert("INSERT INTO `app_user` " +
            "(`id`, `name`, `password_hash`, `role`) " +
            "VALUES (#{id}, #{name}, #{password}, #{role})")
    User persist(@NotNull final User user) throws Exception;

    @Nullable
    @Update("UPDATE `app_user` " +
            "SET `name` = #{name}, " +
            "`password_hash` = #{password}, `role` = #{role}" +
            "WHERE `id` = #{id}")
    User merge(@NotNull final User user) throws Exception;

    @Nullable
    @Delete("DELETE FROM `app_user` " +
            "WHERE `id` = #{id}")
    User remove(@NotNull final User user) throws Exception;

    @Delete("DELETE * FROM `app_user`")
    void removeAll() throws Exception;

}
