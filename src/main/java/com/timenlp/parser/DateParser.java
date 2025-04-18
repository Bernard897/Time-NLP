package com.timenlp.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class DateParser {

    private static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MM_DD_YYYY = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public Optional<LocalDate> parseDate(String dateString) {
        try {
            return Optional.of(LocalDate.parse(dateString, YYYY_MM_DD));
        } catch (DateTimeParseException e) {
            // Ignore and try the next format
        }

        try {
            return Optional.of(LocalDate.parse(dateString, MM_DD_YYYY));
        } catch (DateTimeParseException e) {
            // Ignore and return empty Optional
        }

        return Optional.empty();
    }
}