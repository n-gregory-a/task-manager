package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    List<Project> findAllByUserId(@NotNull final String userId) throws Exception;

    @Nullable
    @Select("SELECT * FROM `project` " +
            "WHERE `name` = #{name} " +
            "AND `user_id` = #{userId}")
    Project findOne(@NotNull final String userId, @NotNull final String name) throws Exception;

    @Nullable
    @Insert("INSERT INTO `project` " +
            "(`id`, `name`, `description`, `date_start`, `date_finish`, `user_id`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{dateStart}, #{dateFinish}, #{userId}, #{status})")
    Project persist(@NotNull final Project project) throws Exception;

    @Nullable
    @Update("UPDATE `project` " +
            "SET `name` = #{name}, `description` = #{description}, `date_start` = #{dateStart}," +
            "`date_finish` = #{dateFinish}, `user_id` = #{userId}, `status` = #{status}" +
            "WHERE `id` = #{id}")
    Project merge(@NotNull final Project project) throws Exception;

    @Nullable
    @Delete("DELETE FROM `project` " +
            "WHERE `id` = #{id} " +
            "AND `user_id` = #{userId}")
    Project remove(@NotNull final String userId, @NotNull final Project project) throws Exception;

    @Delete("DELETE FROM `project` " +
            "WHERE `user_id` = #{userId}")
    void removeAll(@NotNull final String userId) throws Exception;

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
