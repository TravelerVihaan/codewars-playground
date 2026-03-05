package com.github.vihaan.interview.urlshortener.storage;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUrlStorage implements UrlStorage {

    private final ConcurrentHashMap<String, URL> urlStorage = new ConcurrentHashMap<>();

    @Override
    public URL save(URL urlToSave) {
        return null;
    }

    @Override
    public URL find(URL shortenedUrl) {
        return null;
    }
}
