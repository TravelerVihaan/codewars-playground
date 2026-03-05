package com.github.vihaan.interview.urlshortener.service;

import com.github.vihaan.interview.urlshortener.storage.UrlStorage;

public class UrlShortingService {

    private final UrlStorage urlStorage;
    private final ShorteningStrategy shorteningStrategy;

    public UrlShortingService(UrlStorage urlStorage, ShorteningStrategy shorteningStrategy) {
        this.urlStorage = urlStorage;
        this.shorteningStrategy = shorteningStrategy;
    }


}
