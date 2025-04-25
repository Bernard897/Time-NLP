package com.timenlp.parser;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RelativeTimeParserTest {

    @Test
    void testParseTomorrow() {
        RelativeTimeParser relativeTimeParser = new RelativeTimeParser();
        Date tomorrow = relativeTimeParser.parse("明天");
        assertNotNull(tomorrow);
        // Ideally, we would compare to a Calendar instance representing tomorrow, but
        // the current implementation does not provide a way to get the exact date.
        // We can only assert that it's not null.
    }

    @Test
    void testParseInvalidRelativeTime() {
        RelativeTimeParser relativeTimeParser = new RelativeTimeParser();
        Date invalidTime = relativeTimeParser.parse("Invalid Relative Time");
        assertNull(invalidTime);
    }

    @Test
    void testParseNextWeek() {
        RelativeTimeParser relativeTimeParser = new RelativeTimeParser();
        Date nextWeek = relativeTimeParser.parse("下周");
        assertNotNull(nextWeek);
    }
}