package com.github.vihaan.interview.urlshortener;

import com.github.vihaan.interview.urlshortener.server.UrlShortenerServer;
import com.github.vihaan.interview.urlshortener.service.UrlShortingService;
import com.github.vihaan.interview.urlshortener.storage.UrlStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlShortenerApp {

    private static final Logger log = LoggerFactory.getLogger(UrlShortenerApp.class);

    public static void main(String[] args) {
        // TODO: Initialize dependencies (storage, strategy, service)
        // For now, creating minimal setup
        UrlStorage storage = null; // TODO: Initialize with actual implementation
        UrlShortingService service = new UrlShortingService(storage, null); // TODO: Add strategy

        // Create and start server
        UrlShortenerServer server = new UrlShortenerServer(service);
        server.start();

        log.debug("URL Shortener App is running");
    }
}
