package com.timenlp;

import com.timenlp.entity.DateEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TimeNLPTest {

    @Test
    public void testParseWithFuzzyMatching() {
        TimeNLP timeNLP = new TimeNLP(true);
        DateEntity dateEntity = timeNLP.parse("I will meet you on 2024-01-0x");
        assertNotNull(dateEntity);
    }

    @Test
        public void testParseWithoutFuzzyMatching() {
        TimeNLP timeNLP = new TimeNLP(false);
        DateEntity dateEntity = timeNLP.parse("I will meet you on 2024-01-0x");

        assertNotNull(dateEntity);
    }
}