package com.timenlp;

import com.timenlp.entity.DateEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeNLPTest {

    @Test
    void parseDateTime() {
        TimeNLP timeNLP = new TimeNLP();
        DateEntity dateEntity = timeNLP.parseDateTime("2023-10-27 10:00");
        assertNotNull(dateEntity);
        assertEquals(2023, dateEntity.getYear());
        assertEquals(10, dateEntity.getMonth());
        assertEquals(27, dateEntity.getDay());
        assertEquals(10, dateEntity.getHour());
        assertEquals(0, dateEntity.getMinute());

        dateEntity = timeNLP.parseDateTime("明天 10:00");
        assertNotNull(dateEntity);
        assertEquals(10, dateEntity.getHour());
        assertEquals(0, dateEntity.getMinute());

        dateEntity = timeNLP.parseDateTime("2024-02-29 10:00");
        assertNotNull(dateEntity);
        assertEquals(2024, dateEntity.getYear());
        assertEquals(2, dateEntity.getMonth());
        assertEquals(29, dateEntity.getDay());
        assertEquals(10, dateEntity.getHour());
        assertEquals(0, dateEntity.getMinute());


    }
}