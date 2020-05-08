package ru.naumkin.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

@Getter
@Setter
@NoArgsConstructor
public final class User extends AbstractEntity {

    @NotNull
    private String password = HashGenerator.getHash("password");

    @NotNull
    private RoleType role = RoleType.USER;

    @Override
    public String toString() {
        return "login: " + getName() +
                ", role: " + role.displayName() +
                '}';
    }

}
