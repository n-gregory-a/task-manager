package ru.naumkin.tm.entity;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractEntity {

    @NotNull
    private String id = UUID.randomUUID().toString();

    @NonNull
    private String name;

}
