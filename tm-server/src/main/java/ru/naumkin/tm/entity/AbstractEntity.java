package ru.naumkin.tm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @NonNull
    @Column(name = "name")
    private String name;

}
