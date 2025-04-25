package com.timenlp.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.Date;

public class RelativeTimeParser {

    // Example patterns - refine these to match more relative time expressions
    private final String relativeTimeRegex = "(明天|今天|昨天|下周|上周|明年|去年|下个月|上个月)";
    private final Pattern relativeTimePattern = Pattern.compile(relativeTimeRegex);

    public Date parse(String text) {
        Matcher matcher = relativeTimePattern.matcher(text);
        if (matcher.find()) {
            String relativeTime = matcher.group();
            Calendar cal = Calendar.getInstance();
            Date now = new Date();
            cal.setTime(now);

            switch (relativeTime) {
                case "明天":
                    cal.add(Calendar.DAY_OF_YEAR, 1);
                    break;
                case "今天":
                    break;
                case "昨天":
                    cal.add(Calendar.DAY_OF_YEAR, -1);
                    break;
                case "下周":
                    cal.add(Calendar.WEEK_OF_YEAR, 1);
                    break;
                 case "上周":
                    cal.add(Calendar.WEEK_OF_YEAR, -1);
                    break;
                case "明年":
                    cal.add(Calendar.YEAR, 1);
                    break;
                case "去年":
                    cal.add(Calendar.YEAR, -1);
                    break;
                case "下个月":
                    cal.add(Calendar.MONTH, 1);
                    break;
                case "上个月":
                    cal.add(Calendar.MONTH, -1);
                    break;
                default:
                    return null; // Unrecognized relative time
            }

            return cal.getTime();
        }
        return null; // No relative time expression found
    }

       // Method to update the regex patterns for testing/configuration
    public void setRelativeTimeRegex(String regex) {
      Pattern pattern = Pattern.compile(regex);
       }

}