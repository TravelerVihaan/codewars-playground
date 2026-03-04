package com.github.vihaan.interview.urlshortener.server;

import io.javalin.Javalin;

public final class UrlShortenerServer {

    private static final int SERVER_PORT = 8081;
    private static Javalin server;

    private UrlShortenerServer() {}

    public static Javalin startServer() {
        if (server == null) {
            server = Javalin.create().start(SERVER_PORT);
        }
        return server;
    }
}
