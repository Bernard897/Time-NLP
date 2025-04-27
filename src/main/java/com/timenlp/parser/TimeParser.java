package com.timenlp.parser;

import com.timenlp.entity.DateEntity;
import com.timenlp.util.ResourceLoader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeParser {

    private boolean fuzzyMatching;
    private static final String timeRegex = ResourceLoader.loadRegex("time.regex");

    public TimeParser(boolean fuzzyMatching) {
        this.fuzzyMatching = fuzzyMatching;
    }

    public DateEntity parse(String text, DateEntity dateEntity) {
        Pattern pattern = Pattern.compile(timeRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String time = matcher.group();
            if (fuzzyMatching) {
                time = fuzzyMatch(time);
            }
            dateEntity.setTime(time);
            break;
        }
        return dateEntity;
    }

    private String fuzzyMatch(String input) {
          //Very basic fuzzy matching logic
        String timeRegexPattern = "(0?[0-9]|1[0-9]|2[0-3])(:([0-5][0-9])){1,2}"; // Example: HH:MM or H:MM or HH:MM:SS
        if (input.matches(timeRegexPattern)) {
            return input;
        }

        //If input is close enough to the pattern above
        //calculate the Levenshtein distance via external utils library.
        //Could potentially return the best matching time using distance.
        return input; // Return the original input if no fuzzy matching applied.

    }
}