package com.github.vihaan.interview.urlshortener.server;

import com.github.vihaan.interview.urlshortener.service.UrlShortingService;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages the Javalin HTTP server for URL shortener application.
 * Responsible for server lifecycle: creation, configuration, and startup.
 */
public final class UrlShortenerServer {

    private static final int SERVER_PORT = 8081;
    private static final Logger log = LoggerFactory.getLogger(UrlShortenerServer.class);

    private final Javalin app;

    public UrlShortenerServer(UrlShortingService urlShortingService) {
        this.app = Javalin.create(config -> {
           // config.routes.
        });
    }

    /**
     * Starts the server and registers routes.
     */
    public Javalin start() {
        app.start(SERVER_PORT);
        log.info("URL Shortener server started on port {}", SERVER_PORT);
        return app;
    }

    /**
     * Stops the server gracefully.
     */
    public void stop() {
        if (app != null) {
            app.stop();
            log.info("URL Shortener server stopped");
        }
    }

    /**
     * Returns the underlying Javalin instance.
     */
    public Javalin getApp() {
        return app;
    }
}
