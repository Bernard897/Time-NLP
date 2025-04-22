package com.timenlp.parser;

import com.timenlp.entity.TimeEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelativeTimeParserTest {

    @Test
    void parseNextWeek() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("下周", baseTime);
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(5, result.getDay());
    }

    @Test
    void parseLastWeek() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("上周", baseTime);
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(22, result.getDay());
    }

     @Test
    void parseThisWeek() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("这周", baseTime);
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(28, result.getDay());
    }

    @Test
    void parseNextMonth() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("下个月", baseTime);
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(29, result.getDay());
    }

    @Test
    void parseLastMonth() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("上个月", baseTime);
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(12, result.getMonth());
        assertEquals(29, result.getDay());
    }

    @Test
    void parseThisMonth() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("这个月", baseTime);
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(29, result.getDay());
    }

    @Test
    void parseNextYear() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("明年", baseTime);
        assertNotNull(result);
        assertEquals(2025, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(29, result.getDay());
    }

    @Test
    void parseLastYear() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("去年", baseTime);
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(29, result.getDay());
    }

    @Test
    void parseThisYear() {
        RelativeTimeParser parser = new RelativeTimeParser();
        TimeEntity baseTime = new TimeEntity(2024, 1, 29, 12, 0, 0);
        TimeEntity result = parser.parse("今年", baseTime);
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(29, result.getDay());
    }

}
