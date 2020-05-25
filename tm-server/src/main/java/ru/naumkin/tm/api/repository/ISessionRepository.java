package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Session;

import java.util.List;

public interface ISessionRepository {

    @NotNull
    @Select("SELECT * FROM `session`")
    List<Session> findAll() throws Exception;

    @Nullable
    @Select("SELECT * FROM `session` " +
            "WHERE `id` = #{id}")
    Session findOne(@NotNull final String id) throws Exception;

    @Nullable
    @Insert("INSERT INTO `session` " +
            "(`id`, `name`, `timestamp`, `user_id`, `signature`) " +
            "VALUES (#{id}, #{name}, #{timestamp}, #{userId}, #{signature})")
    Session persist(@NotNull final Session session) throws Exception;

    @Nullable
    @Update("UPDATE `session` " +
            "SET `name` = #{name}, `timestamp` = #{timestamp}, " +
            "`user_id` = #{userId}, `signature` = #{signature}" +
            "WHERE `id` = #{id}")
    Session merge(@NotNull final Session session) throws Exception;

    @Nullable
    @Delete("DELETE FROM `session` " +
            "WHERE `id` = #{id}")
    Session remove(@NotNull final Session session) throws Exception;

    @Delete("DELETE * FROM `session`")
    void removeAll() throws Exception;

}
