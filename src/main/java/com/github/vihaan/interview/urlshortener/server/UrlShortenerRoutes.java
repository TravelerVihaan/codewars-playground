package com.github.vihaan.interview.urlshortener.server;

import com.github.vihaan.interview.urlshortener.UrlDto;
import com.github.vihaan.interview.urlshortener.service.UrlShortingService;
import io.javalin.config.RoutesConfig;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines all API endpoints for the URL Shortener application.
 * Separating routes into their own class keeps the server configuration clean
 * and makes route management more maintainable.
 */
public class UrlShortenerRoutes {

    private static final Logger log = LoggerFactory.getLogger(UrlShortenerRoutes.class);

    private UrlShortenerRoutes() {
        // Private constructor to prevent instantiation
    }

    /**
     * Registers all routes with the Javalin application.
     *
     * @param app     the Javalin application instance
     * @param service the URL shortening service
     */
    public static void registerRoutes(RoutesConfig app, UrlShortingService service) {
        // Get shortened URL and redirect to original
        app.get("/{shortenedUrl}", ctx -> handleGetShortenedUrl(ctx, service));

        // Create a new shortened URL
        app.post("/url", ctx -> handlePostUrl(ctx, service));
    }

    /**
     * Handles GET requests to retrieve and redirect to the original URL.
     */
    private static void handleGetShortenedUrl(Context ctx, UrlShortingService service) {
        String shortenedUrl = ctx.pathParam("shortenedUrl");
        log.debug("Attempting to retrieve original URL for shortened URL: {}", shortenedUrl);

        // TODO: Implement the logic to fetch original URL from service
        // String originalUrl = service.expandUrl(shortenedUrl);
        // ctx.redirect(originalUrl);

        ctx.json(new ApiResponse("success", "Retrieved URL: " + shortenedUrl));
    }

    /**
     * Handles POST requests to create a new shortened URL.
     */
    private static void handlePostUrl(Context ctx, UrlShortingService service) {
        try {
            UrlDto urlDto = ctx.bodyAsClass(UrlDto.class);
            log.debug("Creating shortened URL for: {}", urlDto.getUrl());

            // TODO: Implement the logic to shorten the URL
            // String shortenedUrl = service.shortenUrl(urlDto.getUrl());
            // ctx.json(new UrlDto(shortenedUrl));

            ctx.json(new ApiResponse("success", "URL shortened: " + urlDto.getUrl()));
        } catch (Exception e) {
            log.error("Error processing URL shortening request", e);
            ctx.status(400).json(new ApiResponse("error", "Invalid request"));
        }
    }

    /**
     * Simple response wrapper for API responses.
     */
    private static class ApiResponse {
        public final String status;
        public final String message;

        ApiResponse(String status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}

