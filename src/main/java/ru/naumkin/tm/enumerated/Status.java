package ru.naumkin.tm.enumerated;

import org.jetbrains.annotations.NotNull;

public enum Status {

    PLANNED("planned"),
    IN_PROCESS("in process"),
    COMPLETED("completed");

    private final String status;

    Status(@NotNull String status) {
        this.status = status;
    }

    @NotNull
    public String displayStatus() {
        return status;
    }

}
