package com.timenlp.parser;

import com.timenlp.entity.DateEntity;
import com.timenlp.util.ResourceLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {
    private boolean fuzzyMatching;
    private static final String dateRegex = ResourceLoader.loadRegex("date.regex");

    public DateParser(boolean fuzzyMatching) {
        this.fuzzyMatching = fuzzyMatching;
    }

    public DateEntity parse(String text) {
        DateEntity dateEntity = new DateEntity();
        Pattern pattern = Pattern.compile(dateRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String date = matcher.group();
            if (fuzzyMatching) {
                date = fuzzyMatch(date);
            }
            dateEntity.setDate(date);
            break;
        }

        return dateEntity;
    }

    private String fuzzyMatch(String input) {
        //  Very basic fuzzy matching logic
        String dateRegexPattern = "(19|20)\d{2}[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])"; // Example : YYYY-MM-DD
        if (input.matches(dateRegexPattern)) {
            return input;
        }
        //If input is close enough to the pattern above
        //calculate the Levenshtein distance via external utils library.
        //Could potentially return the best matching date using distance.

         return input; // Return the original input if no fuzzy matching applied.
    }
}