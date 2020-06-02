package ru.naumkin.tm.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.api.service.IUserService;
import ru.naumkin.tm.entity.Session;

public class SessionDTO extends AbstractDTO {

    @Getter
    @Setter
    @NotNull
    private Long timestamp;

    @Getter
    @Setter
    @NotNull
    private String userId;

    @Getter
    @Setter
    @Nullable
    private String signature;

    @NotNull
    public Session convertToSession(
            @NotNull final SessionDTO sessionDTO,
            @NotNull final IUserService userService
    ) {
        @NotNull final Session session = new Session();
        session.setId(sessionDTO.getId());
        session.setName(sessionDTO.getName());
        session.setTimestamp(sessionDTO.getTimestamp());
        session.setUser(userService.findOneById(userId));
        session.setSignature(sessionDTO.getSignature());
        return session;
    }

}
