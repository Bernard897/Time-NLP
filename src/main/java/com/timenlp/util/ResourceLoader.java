package com.timenlp.util;

import java.io.InputStream;

public class ResourceLoader {

    public InputStream loadResource(String path) {
        return getClass().getClassLoader().getResourceAsStream(path);
    }
}