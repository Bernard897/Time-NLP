package com.timenlp.parser;

import com.timenlp.parser.DateParser;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DateParserTest {

    private DateParser dateParser = new DateParser();

    @Test
    public void testParseDateRange() {
        Date date = dateParser.parseDate("from 2023-01-01 to 2023-01-05");
        assertNotNull(date);
    }
    
    @Test
    public void testParseSimpleDate(){  // Test Simple date parsing
        Date date = dateParser.parseDate("2024-01-01");
        assertNotNull(date);
    }

    @Test
    public void testParseChineseDate(){// Test Chinese date parsing
        Date date = dateParser.parseDate("2024年02月03日");
        assertNotNull(date);
    }

    @Test
    public void testParseInvalidDate() {
        Date date = dateParser.parseDate("Invalid Date");
        assertNull(date);
    }

 
}