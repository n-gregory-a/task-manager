package ru.naumkin.tm.api.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @NotNull
    @Select("SELECT * FROM `task`")
    List<Task> findAll() throws Exception;

    @NotNull
    @Select("SELECT * FROM `task` " +
            "WHERE `user_id` = #{userId}")
    List<Task> findAllByUserId(@NotNull final String userId) throws Exception;

    @Nullable
    @Select("SELECT * FROM `task` " +
            "WHERE `name` = #{name} " +
            "AND `user_id` = #{userId}")
    Task findOneByUserId(@NotNull final String userId, @NotNull final String name) throws Exception;

    @Nullable
    @Insert("INSERT INTO `task` " +
            "(`id`, `name`, `description`, `date_start`, `date_finish`, `project_id`, `user_id`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{dateStart}, #{dateFinish}, #{projectId}, #{userId}, #{status})")
    Task persist(@NotNull final Task task) throws Exception;

    @Nullable
    @Update("UPDATE `task` " +
            "SET `name` = #{name}, `description` = #{description}, `date_start` = #{dateStart}," +
            "`date_finish` = #{dateFinish}, `project_id` = #{projectId}, `user_id` = #{userId}, `status` = #{status}" +
            "WHERE `id` = #{id}")
    Task merge(@NotNull final Task task) throws Exception;

    @Nullable
    @Delete("DELETE FROM `task` " +
            "WHERE `id` = #{id} " +
            "AND `user_id` = #{userId}")
    Task remove(@NotNull final String userId, @NotNull final Task task) throws Exception;

    @Delete("DELETE FROM `task` " +
            "WHERE `user_id` = #{userId}")
    void removeAll(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `task` " +
            "WHERE `user_id` = #{userId} " +
            "ORDER BY `date_start`")
    List<Task> sortByDateStart(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `task` " +
            "WHERE `user_id` = #{userId} " +
            "ORDER BY `date_finish`")
    List<Task> sortByDateFinish(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `task` " +
            "WHERE `user_id` = #{userId} " +
            "ORDER `status`")
    List<Task> sortByStatus(@NotNull final String userId) throws Exception;

    @NotNull
    @Select("SELECT * FROM `task` " +
            "WHERE `user_id` = #{userId} " +
            "AND `name` LIKE `%#{name}%`")
    List<Task> sortByName(@NotNull final String userId, @NotNull final String name) throws Exception;

    @NotNull
    @Select("SELECT * FROM `task` " +
            "WHERE `user_id` = #{userId} " +
            "AND `description` LIKE `%#{description}%`")
    List<Task> sortByDescription(@NotNull final String userId, @NotNull final String description) throws Exception;

}
