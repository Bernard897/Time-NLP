package com.timenlp.parser;

import com.timenlp.entity.TimeEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeParserTest {

    @Test
    void parse_validTime_parsesCorrectly() {
        TimeParser parser = new TimeParser();
        TimeEntity timeEntity = parser.parse("14:30:00");
        assertNotNull(timeEntity);
        assertEquals(14, timeEntity.getHour());
        assertEquals(30, timeEntity.getMinute());
        assertEquals(0, timeEntity.getSecond());
    }

    @Test
    void parse_invalidTime_returnsNull() {
        TimeParser parser = new TimeParser();
        TimeEntity timeEntity = parser.parse("invalid time");
        assertNull(timeEntity);
    }

    @Test
    void parse_timeWithAM_parsesCorrectly() {
        TimeParser parser = new TimeParser();
        TimeEntity timeEntity = parser.parse("2:30 AM");
        assertNotNull(timeEntity);
        assertEquals(2, timeEntity.getHour());
        assertEquals(30, timeEntity.getMinute());
        assertEquals(0, timeEntity.getSecond());
    }

    @Test
    void parse_timeWithPM_parsesCorrectly() {
        TimeParser parser = new TimeParser();
        TimeEntity timeEntity = parser.parse("2:30 PM");
        assertNotNull(timeEntity);
        assertEquals(14, timeEntity.getHour());
        assertEquals(30, timeEntity.getMinute());
        assertEquals(0, timeEntity.getSecond());
    }

    @Test
      void parse_timeWith12AM_parsesCorrectly() {
        TimeParser parser = new TimeParser();
        TimeEntity timeEntity = parser.parse("12:00 AM");
        assertNotNull(timeEntity);
        assertEquals(0, timeEntity.getHour());
        assertEquals(0, timeEntity.getMinute());
        assertEquals(0, timeEntity.getSecond());
    }

    @Test
    void parse_timeWith12PM_parsesCorrectly() {
        TimeParser parser = new TimeParser();
        TimeEntity timeEntity = parser.parse("12:00 PM");
        assertNotNull(timeEntity);
        assertEquals(12, timeEntity.getHour());
        assertEquals(0, timeEntity.getMinute());
        assertEquals(0, timeEntity.getSecond());
    }
}