package com.timenlp.parser;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class RelativeTimeParserTest {

    @Test
    void parseToday() {
        RelativeTimeParser parser = new RelativeTimeParser();
        String expected = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        assertEquals(expected, parser.parse("today"));
        assertEquals(expected, parser.parse("Today"));
    }

    @Test
    void parseTomorrow() {
        RelativeTimeParser parser = new RelativeTimeParser();
        String expected = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        assertEquals(expected, parser.parse("tomorrow"));
        assertEquals(expected, parser.parse("Tomorrow"));
    }

    @Test
    void parseYesterday() {
        RelativeTimeParser parser = new RelativeTimeParser();
        String expected = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        assertEquals(expected, parser.parse("yesterday"));
        assertEquals(expected, parser.parse("Yesterday"));
    }

    @Test
    void parseInvalidInput() {
        RelativeTimeParser parser = new RelativeTimeParser();
        assertNull(parser.parse("invalid"));
    }
}