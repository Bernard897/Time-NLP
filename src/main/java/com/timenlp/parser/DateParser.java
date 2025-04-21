package com.timenlp.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.timenlp.util.ResourceLoader;

public class DateParser {

    private final String dateRegex;
    private final Pattern datePattern;

    public DateParser() {
        this.dateRegex = ResourceLoader.loadRegex("date.regex");
        this.datePattern = Pattern.compile(dateRegex);
    }

    public String parse(String text) {
        Matcher matcher = datePattern.matcher(text);
        if (matcher.find()) {
            // Extract date components and reformat as needed (yyyy-MM-dd)
            String year = matcher.group("year");
            String month = matcher.group("month");
            String day = matcher.group("day");

            if (year != null && month != null && day != null) {
                // Basic reformatting logic, adjust as needed for different formats
                if (month.length() == 3) { //handles month names like 'Jan'
                    month = convertMonthNameToNumber(month);
                }
                return String.format("%s-%s-%s", year, month, day);
            }
        }
        return null;
    }

    private String convertMonthNameToNumber(String month) {
        switch (month.toLowerCase()) {
            case "jan": return "01";
            case "feb": return "02";
            case "mar": return "03";
            case "apr": return "04";
            case "may": return "05";
            case "jun": return "06";
            case "jul": return "07";
            case "aug": return "08";
            case "sep": return "09";
            case "oct": return "10";
            case "nov": return "11";
            case "dec": return "12";
            default: return "00"; // Handle invalid month
        }
    }
}