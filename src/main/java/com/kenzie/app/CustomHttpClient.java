package com.kenzie.app;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CustomHttpClient {
    public static String sendGET(String URLString) {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(URLString);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                return String.format("GET request failed: %d status code received %s", statusCode, httpResponse.body());
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }
}

