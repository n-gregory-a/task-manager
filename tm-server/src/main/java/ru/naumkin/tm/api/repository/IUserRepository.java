package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.User;

import java.util.List;

public interface IUserRepository {

    @NotNull
    @Select("SELECT * FROM `app_user`")
    @Results(value = {
            @Result(property = "password", column = "password_hash"),
    })
    List<User> findAll() throws Exception;

    @Nullable
    @Select("SELECT * FROM `app_user` " +
            "WHERE `name` = #{name}")
    @Results(value = {
            @Result(property = "password", column = "password_hash"),
    })
    User findOne(@NotNull final String name) throws Exception;

    @Nullable
    @Select("SELECT * FROM `app_user` " +
            "WHERE `id` = #{id}")
    @Results(value = {
            @Result(property = "password", column = "password_hash"),
    })
    User findOneById(@NotNull final String id) throws Exception;

    @Insert("INSERT INTO `app_user` " +
            "(`id`, `name`, `password_hash`, `role`) " +
            "VALUES (#{id}, #{name}, #{password}, #{role})")
    void persist(@NotNull final User user) throws Exception;

    @Update("UPDATE `app_user` " +
            "SET `name` = #{name}, " +
            "`password_hash` = #{password}, `role` = #{role}" +
            "WHERE `id` = #{id}")
    void merge(@NotNull final User user) throws Exception;

    @Delete("DELETE FROM `app_user` " +
            "WHERE `id` = #{id}")
    void remove(@NotNull final User user) throws Exception;

    @Delete("DELETE FROM `app_user`")
    void removeAll() throws Exception;

}
