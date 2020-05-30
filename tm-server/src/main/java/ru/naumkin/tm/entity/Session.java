package ru.naumkin.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
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
    private User user;

    @Getter
    @Setter
    @Nullable
    @Column(name = "signature")
    private String signature;

}
