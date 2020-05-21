package ru.naumkin.tm.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateFormatter {

    @NotNull
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy");

    public static String convertDateToString(@Nullable final Date date) {
        if (date == null) {
            return "not assigned";
        }
        return FORMATTER.format(date);
    }

    public static Date convertStringToDate(@NotNull final String date) throws ParseException {
        return FORMATTER.parse(date);
    }

    public static java.sql.Date convertToSqlDate(@NotNull final Date date) {
        return new java.sql.Date(date.getTime());
    }

}
