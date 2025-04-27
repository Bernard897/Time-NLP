package com.timenlp;

import com.timenlp.entity.DateEntity;
import com.timenlp.parser.DateParser;
import com.timenlp.parser.TimeParser;

public class TimeNLP {

    private boolean fuzzyMatching = false;

    public TimeNLP() {}

    public TimeNLP(boolean fuzzyMatching) {
        this.fuzzyMatching = fuzzyMatching;
    }

    public boolean isFuzzyMatching() {
        return fuzzyMatching;
    }

    public void setFuzzyMatching(boolean fuzzyMatching) {
        this.fuzzyMatching = fuzzyMatching;
    }


    public DateEntity parse(String text) {
        DateEntity dateEntity = new DateEntity();
        DateParser dateParser = new DateParser(fuzzyMatching);
        TimeParser timeParser = new TimeParser(fuzzyMatching);

        dateEntity = dateParser.parse(text);
        dateEntity = timeParser.parse(text, dateEntity);

        return dateEntity;
    }
}