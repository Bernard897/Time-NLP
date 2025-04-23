package com.timenlp.parser;

import com.timenlp.entity.DateEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeParser {

    private static final String HHMM_REGEX = "\\b(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]\\b";
    private static final String HHMMSS_REGEX = "\\b(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\b";

    private static final Pattern HHMM_PATTERN = Pattern.compile(HHMM_REGEX);
    private static final Pattern HHMMSS_PATTERN = Pattern.compile(HHMMSS_REGEX);

    public void parseTimeOfDay(String text, DateEntity dateEntity) {
        Matcher hhmmMatcher = HHMM_PATTERN.matcher(text);
        if (hhmmMatcher.find()) {
            String timeStr = hhmmMatcher.group();
            String[] parts = timeStr.split(":");
            dateEntity.setHour(Integer.parseInt(parts[0]));
            dateEntity.setMinute(Integer.parseInt(parts[1]));
        }

        Matcher hhmmssMatcher = HHMMSS_PATTERN.matcher(text);
        if (hhmmssMatcher.find()) {
            String timeStr = hhmmssMatcher.group();
            String[] parts = timeStr.split(":");
            dateEntity.setHour(Integer.parseInt(parts[0]));
            dateEntity.setMinute(Integer.parseInt(parts[1]));
            dateEntity.setSecond(Integer.parseInt(parts[2]));
        }
    }

    public DateEntity parse(String text, DateEntity dateEntity) {
        parseTimeOfDay(text, dateEntity);
        return dateEntity;
    }


}