package ru.naumkin.tm.enumerated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Status {

    PLANNED("planned"),
    IN_PROGRESS("in progress"),
    COMPLETED("completed");

    private final String status;

    Status(@NotNull final String status) {
        this.status = status;
    }

    @NotNull
    public String displayStatus() {
        return status;
    }

    @NotNull
    public static Status getStatus(@NotNull final String status) {
        for (@NotNull final Status s: Status.values()) {
            if (s.displayStatus().equals(status)) {
                return s;
            }
        }
        throw new RuntimeException();
    }

}
