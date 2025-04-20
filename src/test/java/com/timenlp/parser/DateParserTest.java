package com.timenlp.parser;

import com.timenlp.entity.DateEntity;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void parseDateYMD() throws ParseException {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parseDate("2023-10-26");
        assertNotNull(dateEntity);
        assertEquals(2023, dateEntity.year);
        assertEquals(10, dateEntity.month);
        assertEquals(26, dateEntity.day);
    }

    @Test
    void parseDateDMY() throws ParseException {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parseDate("26-10-2023");
        assertNotNull(dateEntity);
        assertEquals(2023, dateEntity.year);
        assertEquals(10, dateEntity.month);
        assertEquals(26, dateEntity.day);
    }

    @Test
     void parseDateWithSlashes() throws ParseException {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parseDate("2023/10/26");
        assertNotNull(dateEntity);
        assertEquals(2023, dateEntity.year);
        assertEquals(10, dateEntity.month);
        assertEquals(26, dateEntity.day);
    }

    @Test
    void parseDateSingleDigitDayMonth() throws ParseException {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parseDate("2023-1-1");
        assertNotNull(dateEntity);
        assertEquals(2023, dateEntity.year);
        assertEquals(1, dateEntity.month);
        assertEquals(1, dateEntity.day);
    }

    @Test
    void parseDateTwoDigitYear() throws ParseException {
       DateParser dateParser = new DateParser();
       DateEntity dateEntity = dateParser.parseDate("23-10-26");
       assertNotNull(dateEntity);
       assertEquals(2023, dateEntity.year);
       assertEquals(10, dateEntity.month);
       assertEquals(26, dateEntity.day);
    }

    @Test
    void parseDateWithLeadingZeros() throws ParseException {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parseDate("2023-01-01");
        assertNotNull(dateEntity);
        assertEquals(2023, dateEntity.year);
        assertEquals(1, dateEntity.month);
        assertEquals(1, dateEntity.day);
    }
    @Test
    void parseDateWithInvalidDate() {
        DateParser dateParser = new DateParser();
        assertThrows(ParseException.class, () -> dateParser.parseDate("2023-02-30"));
    }

    @Test
    void parseDateWithInvalidFormat() {
        DateParser dateParser = new DateParser();
        assertThrows(ParseException.class, () -> dateParser.parseDate("October 26, 2023"));
    }

    @Test
    void parseDateWithEmptyString() {
        DateParser dateParser = new DateParser();
        assertThrows(ParseException.class, () -> dateParser.parseDate(""));
    }

    @Test
    void parseDateWithNullString() {
        DateParser dateParser = new DateParser();
        assertThrows(NullPointerException.class, () -> dateParser.parseDate(null));
    }

}
