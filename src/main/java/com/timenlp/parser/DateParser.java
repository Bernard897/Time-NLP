package com.timenlp.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {

    private static final String DATE_RANGE_REGEX = "from\s+(.+?)\s+to\s+(.+?)";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date parseDate(String text) {
        Date date = null;
        date = parseDateRange(text); // Attempt to parse the expression as a date range first.
        if (date == null) { // If not a date range, try parsing as a single date.
          try {
            date = dateFormat.parse(text);
          } catch (ParseException e) {
            // Try other date parsing logic if needed
              // e.g., parsing dates containing "年", "月", "日"
              date = parseChineseDate(text); // Use the Chinese date parser
              if (date == null) {
                  System.out.println("Date parsing failed for: " + text);
              }

          }
        }
        return date;
    }

    private Date parseDateRange(String text) {
        Pattern pattern = Pattern.compile(DATE_RANGE_REGEX);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String startDateText = matcher.group(1);
            String endDateText = matcher.group(2);

            Date startDate = parseDate(startDateText);
            Date endDate = parseDate(endDateText);

            if (startDate != null && endDate != null) {
                // For simplicity, we'll just return the start date.  In a real-world
                // scenario, you might want to return a DateRange object encapsulating 
                // both the start and end dates. Or return a List of dates.
                return startDate; 
            }
        }
        return null;
    }

    private Date parseChineseDate(String text) { // A rudimentary Chinese date parser
        Pattern pattern = Pattern.compile("(\d+)年(\d+)月(\d+)日");
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()) {
            int year = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int day = Integer.parseInt(matcher.group(3));

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month -1 , day);
            return calendar.getTime();

        }
        return null;
    }


}