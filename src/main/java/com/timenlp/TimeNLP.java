package com.timenlp;

import com.timenlp.entity.DateEntity;
import com.timenlp.entity.TimeEntity;
import com.timenlp.parser.DateParser;
import com.timenlp.parser.TimeParser;

public class TimeNLP {

    private DateParser dateParser;
    private TimeParser timeParser;

    public TimeNLP() {
        this.dateParser = new DateParser();
        this.timeParser = new TimeParser();
    }

    public DateEntity parseDate(String text) {
        return dateParser.parse(text);
    }

    public TimeEntity parseTime(String text) {
        return timeParser.parse(text);
    }

    public DateEntity parseDateTime(String text) {
        // Attempt to parse as combined date and time
        String[] parts = text.split(" ");
        if (parts.length >= 2) {
            DateEntity dateEntity = dateParser.parse(parts[0]);
            TimeEntity timeEntity = timeParser.parse(parts[1]);

            if (dateEntity != null && timeEntity != null) {
                dateEntity.setHour(timeEntity.getHour());
                dateEntity.setMinute(timeEntity.getMinute());
                dateEntity.setSecond(timeEntity.getSecond());
                return dateEntity;
            }
        }
        DateEntity dateEntity = dateParser.parse(text);
        if (dateEntity != null) {
            return dateEntity;
        }
        // Fallback to individual parsing if combined fails
        TimeEntity timeEntity = timeParser.parse(text);
        if (timeEntity != null) {
            DateEntity now =  dateParser.parse("今天");
            if (now != null){
                   now.setHour(timeEntity.getHour());
                   now.setMinute(timeEntity.getMinute());
                   now.setSecond(timeEntity.getSecond());
                   return now;
            }

        }


        return null;
    }

    public static void main(String[] args) {
        TimeNLP timeNLP = new TimeNLP();
        DateEntity dateEntity = timeNLP.parseDateTime("2023-10-27 10:00");
        if (dateEntity != null) {
            System.out.println("Date: " + dateEntity.getYear() + "-" + dateEntity.getMonth() + "-" + dateEntity.getDay() +
                    " " + dateEntity.getHour() + ":" + dateEntity.getMinute());
        } else {
            System.out.println("Could not parse date and time.");
        }

        dateEntity = timeNLP.parseDateTime("明天 10:00");
        if (dateEntity != null) {
            System.out.println("Date: " + dateEntity.getYear() + "-" + dateEntity.getMonth() + "-" + dateEntity.getDay() +
                    " " + dateEntity.getHour() + ":" + dateEntity.getMinute());
        } else {
            System.out.println("Could not parse date and time.");
        }
        dateEntity = timeNLP.parseDateTime("2024-02-29 10:00");
        if (dateEntity != null) {
            System.out.println("Date: " + dateEntity.getYear() + "-" + dateEntity.getMonth() + "-" + dateEntity.getDay() +
                    " " + dateEntity.getHour() + ":" + dateEntity.getMinute());
        } else {
            System.out.println("Could not parse date and time.");
        }

    }
}
