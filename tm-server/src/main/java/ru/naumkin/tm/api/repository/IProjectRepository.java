package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Project;

import java.util.List;

public interface IProjectRepository {

    @NotNull
    @Select("SELECT * FROM `project`")
    List<Project> findAll() throws Exception;

    @NotNull
    @Select("SELECT * FROM `project` " +
            "WHERE `user_id` = #{userId}")
    @Results(value = {
            @Result(property = "dateStart", column = "date_start"),
            @Result(property = "dateFinish", column = "date_finish"),
            @Result(property = "userId", column = "user_id"),
    })
    List<Project> findAllByUserId(@NotNull final String userId) throws Exception;

    @Nullable
    @Select("SELECT * FROM `project` " +
            "WHERE `name` = #{name} " +
            "AND `user_id` = #{userId}")
    @Results(value = {
            @Result(property = "dateStart", column = "date_start"),
            @Result(property = "dateFinish", column = "date_finish"),
            @Result(property = "userId", column = "user_id"),
    })
    Project findOne(@NotNull @Param("userId") final String userId,
                    @NotNull @Param("name") final String name) throws Exception;

    @Insert("INSERT INTO `project` " +
            "(`id`, `name`, `description`, `date_start`, `date_finish`, `user_id`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{dateStart}, #{dateFinish}, #{userId}, #{status})")
    void persist(@NotNull final Project project) throws Exception;

    @Update("UPDATE `project` " +
            "SET `name` = #{name}, `description` = #{description}, `date_start` = #{dateStart}," +
            "`date_finish` = #{dateFinish}, `user_id` = #{userId}, `status` = #{status}" +
            "WHERE `id` = #{id}")
    void merge(@NotNull final Project project) throws Exception;

    @Delete("DELETE FROM `project` " +
            "WHERE `id` = #{id} " +
            "AND `user_id` = #{userId}")
    void remove(@NotNull @Param("userId") final String userId,
                @NotNull @Param("id") final String id) throws Exception;

    @Delete("DELETE FROM `project` " +
            "WHERE `user_id` = #{userId}")
    void removeAll(@NotNull @Param("userId") final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `project` " +
            "WHERE `user_id` = #{userId} " +
            "ORDER BY `date_start`")
    List<Project> sortByDateStart(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `project` " +
            "WHERE `user_id` = #{userId} " +
            "ORDER BY `date_finish`")
    List<Project> sortByDateFinish(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `project` " +
            "WHERE `user_id` = #{userId} " +
            "ORDER BY `status`")
    List<Project> sortByStatus(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `project` " +
            "WHERE `user_id` = #{userId} " +
            "AND `name` LIKE `%#{name}%`")
    List<Project> sortByName(@NotNull final String userId, @NotNull final String name) throws Exception;

    @NotNull
    @Select("SELECT * FROM `project` " +
            "WHERE `user_id` = #{userId} " +
            "AND `description` LIKE `%#{description}%`")
    List<Project> sortByDescription(@NotNull final String userId, @NotNull final String description) throws Exception;

}
