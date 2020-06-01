package ru.naumkin.tm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO {

    @NotNull
    private String password = HashGenerator.getHash("password");

    @NotNull
    private RoleType role = RoleType.USER;

    @NotNull
    public User convertToUser(@NotNull final UserDTO userDTO,
                              @NotNull final ServiceLocator serviceLocator
    ) {
        @NotNull final User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setProjects(serviceLocator.getProjectService().findAll(userDTO.getId()));
        user.setTasks(serviceLocator.getTaskService().findAll(userDTO.getId()));
        return user;
    }

}
