package com.timenlp.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateParserTest {

    private final DateParser dateParser = new DateParser();

    @Test
    void testYYYYMMDD() {
        assertEquals("2023-10-26", dateParser.parse("2023-10-26"));
    }

    @Test
    void testMMDDYYYY() {
        assertEquals("2023-10-26", dateParser.parse("10/26/2023"));
    }

    @Test
    void testYYYYMMDDChinese() {
        assertEquals("2023-10-01", dateParser.parse("2023年10月1日"));
    }

    @Test
    void testDDMMMYYYY() {
        assertEquals("2024-01-05", dateParser.parse("5 Jan 2024"));
    }

    @Test
    void testMMMDDYYYY() {
        assertEquals("2024-02-12", dateParser.parse("Feb 12, 2024"));
    }
}