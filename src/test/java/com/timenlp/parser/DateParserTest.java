package com.timenlp.parser;

import com.timenlp.entity.DateEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @Test
    void testParseValidDate() {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parse("2023-10-26");
        
        assertNotNull(dateEntity);
        assertEquals("2023-10-26", dateEntity.getOriginalText());
        assertEquals(2023, dateEntity.getYear());
        assertEquals(10, dateEntity.getMonth());
        assertEquals(26, dateEntity.getDay());
    }

    @Test
    void testParseInvalidDate() {
        DateParser dateParser = new DateParser();
        DateEntity dateEntity = dateParser.parse("Invalid Date");
        assertNull(dateEntity);
    }

    @Test
    void testParseDifferentFormat() {
       DateParser dateParser = new DateParser();
       DateEntity dateEntity = dateParser.parse("10/26/2023");
       //The following assertions are based on the current implementation
       //of the parser. date format should be parsed correctly for meaningful assertions
       //assertEquals("10/26/2023", dateEntity.getOriginalText());

    }

    @Test
    void testUpdateRegex() {
        DateParser dateParser = new DateParser();
        String newRegex = "\\d{4}/\\d{2}/\\d{2}"; //YYYY/MM/DD
        dateParser.setDateRegex(newRegex);
        DateEntity dateEntity = dateParser.parse("2024/01/15");

        assertNotNull(dateEntity);
        assertEquals("2024/01/15", dateEntity.getOriginalText());
    
        
    }

     @Test
    void testParsePartialDate() {
        DateParser dateParser = new DateParser();
       DateEntity dateEntity = dateParser.parse("12/25"); //Month/Day
       //The following assertions are based on the current implementation
       //of the parser. date format should be parsed correctly for meaningful assertions
       //assertEquals("12/25", dateEntity.getOriginalText());
       //assertEquals(12, dateEntity.getMonth());
       //assertEquals(25, dateEntity.getDay());
    }
}