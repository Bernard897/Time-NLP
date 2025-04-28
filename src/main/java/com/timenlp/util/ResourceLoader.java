package com.timenlp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceLoader {

    private static final String CONFIG_FILE = "time-nlp.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ResourceLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
                return;
            }

            //load a properties file from class path, inside static method
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getDateRegexPath() {
        return properties.getProperty("date.regex.path", "regex/date.regex");
    }

    public static String getTimeRegexPath() {
        return properties.getProperty("time.regex.path", "regex/time.regex");
    }
}
