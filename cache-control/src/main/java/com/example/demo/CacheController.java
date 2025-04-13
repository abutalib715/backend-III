package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class CacheController {

    @GetMapping("/cached-data")
    public ResponseEntity<String> getCachedData() {
        System.out.println("serve request");
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))  // Cache for 60 seconds
                .body("This is cached data.");
    }

    @GetMapping("/static")
    public String getStaticData(HttpServletResponse response) {
        System.out.println("serve static");
        response.setHeader("Cache-Control", "max-age=3600, public");
        return "This is static content.";
    }

    @GetMapping("/no-cache")
    public ResponseEntity<String> noCache() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.noCache().mustRevalidate().noStore())
                .body("This response is never cached.");
    }

    @GetMapping("/private-cache")
    public ResponseEntity<String> privateCache() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(3600, TimeUnit.SECONDS).cachePrivate())
                .body("This response is cached in the browser for 1 hour.");
    }

    @GetMapping("/revalidate-cache")
    public ResponseEntity<String> mustRevalidateCache() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS).mustRevalidate())
                .body("This response requires revalidation after 60 seconds.");
    }

//    @GetMapping("/expires")
//    public ResponseEntity<String> expiresHeader() {
//        ZonedDateTime expiryDate = ZonedDateTime.of(2025, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC"));
//        return ResponseEntity.ok()
//                .cacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
//                .expires(Date.from(expiryDate.toInstant()))
//                .body("This response expires on 2025-01-01.");
//    }

    @GetMapping("/etag")
    public ResponseEntity<String> etagResponse(HttpServletRequest request) {
        String etag = "\"123456789\""; // Simulated ETag value
        String ifNoneMatch = request.getHeader("If-None-Match");

        if (etag.equals(ifNoneMatch)) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); // 304 Not Modified
        }

        return ResponseEntity.ok()
                .eTag(etag)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body("This response supports ETag caching.");
    }
//    🔹 Effect:
//
//    If the client already has the cached response with the same ETag, it gets 304 Not Modified instead of downloading it again.
//    Reduces bandwidth and improves performance.
    
}
