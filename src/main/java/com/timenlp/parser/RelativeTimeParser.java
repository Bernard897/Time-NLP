package com.timenlp.parser;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.timenlp.entity.TimeEntity;
import com.timenlp.util.ResourceLoader;

public class RelativeTimeParser {

    private static final Pattern nextWeekPattern = Pattern.compile(ResourceLoader.getRegex("next_week.regex"));
    private static final Pattern lastWeekPattern = Pattern.compile(ResourceLoader.getRegex("last_week.regex"));
    private static final Pattern thisWeekPattern = Pattern.compile(ResourceLoader.getRegex("this_week.regex"));

    private static final Pattern nextMonthPattern = Pattern.compile(ResourceLoader.getRegex("next_month.regex"));
    private static final Pattern lastMonthPattern = Pattern.compile(ResourceLoader.getRegex("last_month.regex"));
    private static final Pattern thisMonthPattern = Pattern.compile(ResourceLoader.getRegex("this_month.regex"));

    private static final Pattern nextYearPattern = Pattern.compile(ResourceLoader.getRegex("next_year.regex"));
    private static final Pattern lastYearPattern = Pattern.compile(ResourceLoader.getRegex("last_year.regex"));
    private static final Pattern thisYearPattern = Pattern.compile(ResourceLoader.getRegex("this_year.regex"));

    public TimeEntity parse(String text, TimeEntity baseTime) {
        TimeEntity time = null;

        Matcher nextWeekMatcher = nextWeekPattern.matcher(text);
        if (nextWeekMatcher.find()) {
            time = adjustDate(baseTime, Calendar.WEEK_OF_YEAR, 1);
            return time;
        }

        Matcher lastWeekMatcher = lastWeekPattern.matcher(text);
        if (lastWeekMatcher.find()) {
            time = adjustDate(baseTime, Calendar.WEEK_OF_YEAR, -1);
            return time;
        }

        Matcher thisWeekMatcher = thisWeekPattern.matcher(text);
        if (thisWeekMatcher.find()) {
            time = new TimeEntity(baseTime.getYear(), baseTime.getMonth(), baseTime.getDay(), baseTime.getHour(), baseTime.getMinute(), baseTime.getSecond());
            Calendar cal = Calendar.getInstance();
            cal.set(baseTime.getYear(), baseTime.getMonth() - 1, baseTime.getDay());
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            int daysToAdd = (Calendar.SUNDAY - dayOfWeek);

            cal.add(Calendar.DATE, daysToAdd);

            time.setYear(cal.get(Calendar.YEAR));
            time.setMonth(cal.get(Calendar.MONTH) + 1);
            time.setDay(cal.get(Calendar.DAY_OF_MONTH));
            return time;
        }

        Matcher nextMonthMatcher = nextMonthPattern.matcher(text);
        if (nextMonthMatcher.find()) {
            time = adjustDate(baseTime, Calendar.MONTH, 1);
            return time;
        }

        Matcher lastMonthMatcher = lastMonthPattern.matcher(text);
        if (lastMonthMatcher.find()) {
            time = adjustDate(baseTime, Calendar.MONTH, -1);
            return time;
        }

        Matcher thisMonthMatcher = thisMonthPattern.matcher(text);
        if (thisMonthMatcher.find()) {
             time = new TimeEntity(baseTime.getYear(), baseTime.getMonth(), baseTime.getDay(), baseTime.getHour(), baseTime.getMinute(), baseTime.getSecond());
             return time;
        }

        Matcher nextYearMatcher = nextYearPattern.matcher(text);
        if (nextYearMatcher.find()) {
            time = adjustDate(baseTime, Calendar.YEAR, 1);
            return time;
        }

        Matcher lastYearMatcher = lastYearPattern.matcher(text);
        if (lastYearMatcher.find()) {
            time = adjustDate(baseTime, Calendar.YEAR, -1);
            return time;
        }

        Matcher thisYearMatcher = thisYearPattern.matcher(text);
        if (thisYearMatcher.find()) {
            time = new TimeEntity(baseTime.getYear(), baseTime.getMonth(), baseTime.getDay(), baseTime.getHour(), baseTime.getMinute(), baseTime.getSecond());
            return time;
        }


        return null;
    }

    private TimeEntity adjustDate(TimeEntity baseTime, int field, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.set(baseTime.getYear(), baseTime.getMonth() - 1, baseTime.getDay());
        cal.add(field, amount);

        TimeEntity time = new TimeEntity();
        time.setYear(cal.get(Calendar.YEAR));
        time.setMonth(cal.get(Calendar.MONTH) + 1);
        time.setDay(cal.get(Calendar.DAY_OF_MONTH));
        time.setHour(baseTime.getHour());
        time.setMinute(baseTime.getMinute());
        time.setSecond(baseTime.getSecond());
        return time;
    }
}
