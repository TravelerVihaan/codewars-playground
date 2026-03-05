package com.github.vihaan.interview.urlshortener.service;

import java.net.URL;

public interface ShorteningStrategy {

    URL transformUrl(URL originalUrl);
}
