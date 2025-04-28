package com.timenlp.parser;

import com.timenlp.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DateParser {
    private List<Pattern> datePatterns = new ArrayList<>();

    public DateParser() {
        loadDateRegex();
    }

    private void loadDateRegex() {
        String path = ResourceLoader.getDateRegexPath();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                    datePatterns.add(Pattern.compile(line.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public List<Pattern> getDatePatterns() {
        return datePatterns;
    }


}