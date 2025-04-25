package com.timenlp;

import com.timenlp.entity.DateEntity;
import com.timenlp.parser.DateParser;
import com.timenlp.parser.RelativeTimeParser;
import com.timenlp.parser.TimeParser;
import com.timenlp.entity.TimeEntity;
import java.util.Date;

public class TimeNLP {

    private final DateParser dateParser;
    private final TimeParser timeParser;
    private final RelativeTimeParser relativeTimeParser;

    public TimeNLP() {
        this.dateParser = new DateParser();
        this.timeParser = new TimeParser();
        this.relativeTimeParser = new RelativeTimeParser();
    }

    public DateEntity parseDate(String text) {
        return this.dateParser.parse(text);
    }

     public Date parseRelativeTime(String text) {
        return this.relativeTimeParser.parse(text);
    }
    public TimeEntity parseTime(String text) {
        return this.timeParser.parse(text);
    }

     // Add method to update date parser regex from outside
    public void setDateRegex(String regex) {
        this.dateParser.setDateRegex(regex);
    }

      // Add method to update relative time regex from outside
    public void setRelativeTimeRegex(String regex) {
        this.relativeTimeParser.setRelativeTimeRegex(regex);
    }


    // Example method combining date, time, relative time (Improve as needed)
    public String parse(String text) {
        DateEntity dateEntity = parseDate(text);
        TimeEntity timeEntity = parseTime(text);
        Date relativeDate = parseRelativeTime(text);

        StringBuilder result = new StringBuilder();

        if (dateEntity != null && dateEntity.getOriginalText() != null) {
            result.append("Date: ").append(dateEntity.getOriginalText()).append("\n");
        }
        if (timeEntity != null && timeEntity.getOriginalText() != null) {
            result.append("Time: ").append(timeEntity.getOriginalText()).append("\n");
        }
        if(relativeDate != null){
          result.append("Relative Time: ").append(relativeDate.toString()).append("\n");
        }


        return result.toString();
    }

}
