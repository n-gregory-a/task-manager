package ru.naumkin.tm.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String convertDateToString(final LocalDate date) {
        return FORMATTER.format(date);
    }

    public static LocalDate convertStringToDate(final String date) {
        return LocalDate.parse(date, FORMATTER);
    }

}
