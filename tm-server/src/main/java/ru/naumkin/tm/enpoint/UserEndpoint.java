package ru.naumkin.tm.enpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.ServiceLocator;
import ru.naumkin.tm.api.endpoint.IUserEndpoint;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.dto.UserDTO;
import ru.naumkin.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@WebService(endpointInterface = "ru.naumkin.tm.api.endpoint.IUserEndpoint")
public final class UserEndpoint extends AbstractEndpoint implements IUserEndpoint {

    @NotNull private IUserService userService;

    public UserEndpoint(@NotNull final ServiceLocator serviceLocator) {
        super(serviceLocator);
        this.userService = serviceLocator.getUserService();
    }

    @NotNull
    @Override
    @WebMethod
    public List<UserDTO> findAllUsers() {
        @NotNull final List<User> users = userService.findAll();
        @NotNull final List<UserDTO> userDTOList = new ArrayList<>();
        for (@NotNull final User user: users) {
            @NotNull final UserDTO userDTO = user.convertToUserDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @NotNull
    @Override
    @WebMethod
    public UserDTO findOneUser(@NotNull final String name) {
        @NotNull final User user = userService.findOne(name);
        return user.convertToUserDTO(user);
    }

    @Override
    @WebMethod
    public void persistUser(@NotNull final UserDTO userDTO) {
        @NotNull final User user = userDTO.convertToUser(userDTO, serviceLocator);
        userService.persist(user);
    }

    @Override
    @WebMethod
    public void mergeUser(
            @NotNull final String sessionToken,
            @NotNull final UserDTO userDTO
    ) throws Exception {
        validate(sessionToken);
        @NotNull final User user = userDTO.convertToUser(userDTO, serviceLocator);
        userService.merge(user);
    }

    @Override
    @WebMethod
    public void removeUser(
            @NotNull final String sessionToken,
            @NotNull final UserDTO userDTO
    ) throws Exception {
        validate(sessionToken);
        @NotNull final User user = userDTO.convertToUser(userDTO, serviceLocator);
        userService.remove(user);
    }

    @Override
    @WebMethod
    public void removeAllUser(@NotNull final String sessionToken) throws Exception {
        validate(sessionToken);
        userService.removeAll();
    }

    @Override
    @WebMethod
    public boolean isRoleAdmin(
            @NotNull final String sessionToken,
            @NotNull final String id
    ) throws Exception {
        validate(sessionToken);
        return userService.isRoleAdmin(id);
    }

}
