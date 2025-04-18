package com.timenlp.parser;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    private final DateParser dateParser = new DateParser();

    @Test
    void parseDate_yyyy_MM_dd() {
        Optional<LocalDate> date = dateParser.parseDate("2023-10-26");
        assertTrue(date.isPresent());
        assertEquals(LocalDate.of(2023, 10, 26), date.get());
    }

    @Test
    void parseDate_MM_dd_yyyy() {
        Optional<LocalDate> date = dateParser.parseDate("10/26/2023");
        assertTrue(date.isPresent());
        assertEquals(LocalDate.of(2023, 10, 26), date.get());
    }

    @Test
    void parseDate_invalidFormat() {
        Optional<LocalDate> date = dateParser.parseDate("2023/10/26");
        assertFalse(date.isPresent());
    }

    @Test
    void parseDate_emptyString() {
        Optional<LocalDate> date = dateParser.parseDate("");
        assertFalse(date.isPresent());
    }

}