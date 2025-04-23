package com.timenlp.parser;

import com.timenlp.entity.DateEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeParserTest {

    @Test
    public void testParseTimeOfDay_HHMM() {
        TimeParser timeParser = new TimeParser();
        DateEntity dateEntity = new DateEntity();
        timeParser.parseTimeOfDay("It is 12:30 now", dateEntity);

        assertEquals(12, dateEntity.getHour());
        assertEquals(30, dateEntity.getMinute());
        assertEquals(-1, dateEntity.getSecond());
    }

    @Test
    public void testParseTimeOfDay_HHMMSS() {
        TimeParser timeParser = new TimeParser();
        DateEntity dateEntity = new DateEntity();
        timeParser.parseTimeOfDay("The time is 08:15:45", dateEntity);

        assertEquals(8, dateEntity.getHour());
        assertEquals(15, dateEntity.getMinute());
        assertEquals(45, dateEntity.getSecond());
    }

    @Test
        public void testParseTimeOfDay_NoTime() {
        TimeParser timeParser = new TimeParser();
        DateEntity dateEntity = new DateEntity();
        timeParser.parseTimeOfDay("This is a test", dateEntity);

        assertEquals(-1, dateEntity.getHour());
        assertEquals(-1, dateEntity.getMinute());
        assertEquals(-1, dateEntity.getSecond());
    }
}