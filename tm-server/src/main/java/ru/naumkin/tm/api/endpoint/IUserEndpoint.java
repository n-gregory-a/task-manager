package ru.naumkin.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.dto.UserDTO;
import ru.naumkin.tm.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IUserEndpoint {

    @NotNull
    @WebMethod
    List<UserDTO> findAllUsers();

    @NotNull
    @WebMethod
    UserDTO findOneUser(@NotNull final String name);

    @WebMethod
    void persistUser(@NotNull final UserDTO userDTO);

    @WebMethod
    void mergeUser(
            @NotNull final String sessionToken,
            @NotNull final UserDTO userDTO) throws Exception;

    @WebMethod
    void removeUser(@NotNull final String sessionToken,
                    @NotNull final UserDTO userDTO) throws Exception;

    @WebMethod
    void removeAllUser(@NotNull final String sessionToken) throws Exception;

    @WebMethod
    boolean isRoleAdmin(@NotNull final String sessionToken, @NotNull final String id) throws Exception;

}
