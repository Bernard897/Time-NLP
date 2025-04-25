package com.timenlp.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.timenlp.entity.DateEntity;
import com.timenlp.util.ResourceLoader;

public class DateParser {

    private final String dateRegexFile = "regex/date.regex";
    private String dateRegex;
    private Pattern datePattern;

    public DateParser() {
        this.dateRegex = ResourceLoader.loadRegex(dateRegexFile);
        this.datePattern = Pattern.compile(this.dateRegex);
    }

    public DateEntity parse(String text) {
        Matcher matcher = this.datePattern.matcher(text);
        DateEntity dateEntity = new DateEntity();
        if (matcher.find()) {
            dateEntity.setOriginalText(matcher.group());
            // Implement logic to extract year, month, day from the matched group
            // Example (This is a placeholder, refine based on your date.regex):
             String matchedDate = matcher.group();
            // Attempt to parse date, handle potential NumberFormatException
            try {
               // Placeholder logic - improve date extraction as needed 
               String[] parts = matchedDate.split("[-/\\.]"); // Use delimiters for parsing different date formats
               if (parts.length == 3) { // Assuming YYYY-MM-DD, MM-DD-YYYY or similar
                  //Example parsing - adjust based on regex
                  dateEntity.setYear(Integer.parseInt(parts[0]));
                  dateEntity.setMonth(Integer.parseInt(parts[1]));
                  dateEntity.setDay(Integer.parseInt(parts[2]));
                }else if(parts.length == 2){
                   //Possibly DD/MM or MM/DD format
                   dateEntity.setMonth(Integer.parseInt(parts[0]));
                   dateEntity.setDay(Integer.parseInt(parts[1]));
                }

            } catch (NumberFormatException e) {
                System.err.println("Error parsing date: " + matchedDate + ", due to: " + e.getMessage());
                // Handle parsing errors gracefully, maybe return a default DateEntity or null
                // For now, keep the original empty DateEntity with the matched text.
            }

        }else{
            return null;
        }

        return dateEntity;
    }

    // Example method to update the date regex (useful for testing)
    public void setDateRegex(String regex) {
        this.dateRegex = regex;
        this.datePattern = Pattern.compile(this.dateRegex);
    }

}