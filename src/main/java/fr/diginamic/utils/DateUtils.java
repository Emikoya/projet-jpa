package fr.diginamic.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Mise en place du format de la date
 */
public class DateUtils {
    public static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }

        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMMM dd yyyy", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMMM dd yyyy", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH)
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Impossible de formater la date");
            }
        }
        throw new IllegalArgumentException("Impossible de parser la date: " + dateString);
    }
}