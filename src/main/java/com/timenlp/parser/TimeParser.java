package com.timenlp.parser;

import com.timenlp.util.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TimeParser {
    private List<Pattern> timePatterns = new ArrayList<>();

    public TimeParser() {
        loadTimeRegex();
    }

    private void loadTimeRegex() {
        String path = ResourceLoader.getTimeRegexPath();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                    timePatterns.add(Pattern.compile(line.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Pattern> getTimePatterns() {
        return timePatterns;
    }
}