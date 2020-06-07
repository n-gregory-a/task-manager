package ru.naumkin.tm.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
import ru.naumkin.tm.dto.UserDTO;
import ru.naumkin.tm.enumerated.RoleType;
import ru.naumkin.tm.util.HashGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Cacheable
@NoArgsConstructor
@Table(name = "app_user")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public final class User extends AbstractEntity {

    @NotNull
    @Column(name = "password_hash")
    private String password = HashGenerator.getHash("password");

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.USER;

    @NotNull
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

    @NotNull
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    @NotNull
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Session> sessions = new ArrayList<>();

    @NotNull
    public UserDTO convertToUserDTO(@NotNull final User user) {
        @NotNull final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

}
