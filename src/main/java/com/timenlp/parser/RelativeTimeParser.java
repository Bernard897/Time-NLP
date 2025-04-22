package com.timenlp.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RelativeTimeParser {

    public String parse(String input) {
        LocalDate today = LocalDate.now();

        if (input.equalsIgnoreCase("today")) {
            return today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else if (input.equalsIgnoreCase("tomorrow")) {
            return today.plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else if (input.equalsIgnoreCase("yesterday")) {
            return today.minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            return null; // Indicate that the input could not be parsed as a relative date.
        }
    }
}