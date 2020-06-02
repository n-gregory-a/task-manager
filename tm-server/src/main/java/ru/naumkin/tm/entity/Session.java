package ru.naumkin.tm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.naumkin.tm.dto.SessionDTO;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "session")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Session extends AbstractEntity implements Cloneable {

    @Override
    public Session clone() {
        try {
            return (Session) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Getter
    @Setter
    @NotNull
    @Column(name = "timestamp")
    private Long timestamp;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @Getter
    @Setter
    @Nullable
    @Column(name = "signature")
    private String signature;

    @NotNull
    public SessionDTO convertToSessionDTO(@NotNull final Session session) {
        @NotNull final SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(session.getId());
        sessionDTO.setName(session.getName());
        sessionDTO.setTimestamp(session.getTimestamp());
        sessionDTO.setUserId(session.getUser().getId());
        sessionDTO.setSignature(session.getSignature());
        return sessionDTO;
    }

}
