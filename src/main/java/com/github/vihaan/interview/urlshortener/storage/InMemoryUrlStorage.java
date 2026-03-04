package com.github.vihaan.interview.urlshortener.storage;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUrlStorage {

    private final ConcurrentHashMap<String, URL> urlStorage = new ConcurrentHashMap<>();
}
