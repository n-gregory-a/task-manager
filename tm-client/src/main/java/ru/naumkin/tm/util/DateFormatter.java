package ru.naumkin.tm.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateFormatter {

    @NotNull
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy");

    @NotNull
    public static String convertDateToString(@Nullable final Date date) {
        if (date == null) {
            return "not assigned";
        }
        return FORMATTER.format(date);
    }

    @NotNull
    public static Date convertStringToDate(@NotNull final String date) throws ParseException {
        return FORMATTER.parse(date);
    }

    @NotNull
    public static XMLGregorianCalendar convertToXmlGregorianCalendar(
            @NotNull final Date date
    ) throws DatatypeConfigurationException {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }

    @NotNull
    public static Date convertToDate(@NotNull final XMLGregorianCalendar calendar) {
        return calendar.toGregorianCalendar().getTime();
    }

}
