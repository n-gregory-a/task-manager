package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import java.util.List;

public interface ISessionRepository {

    @NotNull
    @Select("SELECT * FROM `session`")
    @Results(value = {
            @Result(property = "userId", column = "user_id"),
    })
    List<Session> findAll() throws Exception;

    @Nullable
    @Select("SELECT * FROM `session` " +
            "WHERE `id` = #{id}")
    @Results(value = {
            @Result(property = "userId", column = "user_id"),
    })
    Session findOne(@NotNull @Param("id") final String id) throws Exception;

    @Insert("INSERT INTO `session` " +
            "(`id`, `name`, `timestamp`, `user_id`, `signature`) " +
            "VALUES (#{id}, #{name}, #{timestamp}, #{userId}, #{signature})")
    void persist(@NotNull final Session session) throws Exception;

    @Update("UPDATE `session` " +
            "SET `name` = #{name}, `timestamp` = #{timestamp}, " +
            "`user_id` = #{userId}, `signature` = #{signature}" +
            "WHERE `id` = #{id}")
    void merge(@NotNull final Session session) throws Exception;

    @Delete("DELETE FROM `session` " +
            "WHERE `id` = #{id}")
    void remove(@NotNull @Param("id") final String id) throws Exception;

    @Delete("DELETE FROM `session`")
    void removeAll() throws Exception;

}
