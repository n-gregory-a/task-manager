package ru.naumkin.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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
    private Long timestamp;

    @Getter
    @Setter
    @NotNull
    private String userId;

    @Getter
    @Setter
    @NotNull
    private String signature;

}
