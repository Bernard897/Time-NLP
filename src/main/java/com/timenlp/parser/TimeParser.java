package com.timenlp.parser;

import com.timenlp.entity.TimeEntity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeParser {

    private static final String timeRegex = "((?:(?:[0-1]?[0-9])|(?:2[0-3])):[0-5][0-9](?::[0-5][0-9])?)\s*(?:AM|PM|am|pm)?";

    private static final Pattern timePattern = Pattern.compile(timeRegex);

    public TimeEntity parse(String text) {
        Matcher matcher = timePattern.matcher(text);
        if (matcher.find()) {
            String timeStr = matcher.group(1);
            String ampm = matcher.group(2);
            String[] parts = timeStr.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            int second = 0;
            if (parts.length > 2) {
                second = Integer.parseInt(parts[2]);
            }

            if (ampm != null && (ampm.equalsIgnoreCase("PM") || ampm.equalsIgnoreCase("pm"))) {
                if (hour < 12) {
                    hour += 12;
                }
            } else if (ampm != null && (ampm.equalsIgnoreCase("AM") || ampm.equalsIgnoreCase("am"))) {
                if (hour == 12){
                    hour = 0; // Midnight 12 AM should be treated as 0
                }
            }


            TimeEntity timeEntity = new TimeEntity();
            timeEntity.setHour(hour);
            timeEntity.setMinute(minute);
            timeEntity.setSecond(second);
            return timeEntity;
        }
        return null;
    }
}