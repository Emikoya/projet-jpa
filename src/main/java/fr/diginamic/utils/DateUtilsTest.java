package fr.diginamic.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de la mise en forme de la date
 */
class DateUtilsTest {
    @Test
    public void testParseDate() {
        String dateString = "May 7 1940";
        LocalDate expectedDate = LocalDate.of(1940, 5, 7);
        LocalDate parsedDate = DateUtils.parseDate(dateString);
        assertEquals(expectedDate, parsedDate);
    }
}