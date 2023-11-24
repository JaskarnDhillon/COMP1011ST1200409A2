package com.example.comp1011st1200409a2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    public static void callAPI(String countryName) throws IOException, InterruptedException {
        countryName = countryName.replaceAll(" ","%20");

        String uri = "https://restcountries.com/v3.1/name/"+countryName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> httpResponse = client.send(httpRequest,HttpResponse
                .BodyHandlers
                .ofFile(Paths.get("moreCountries.json")));
    }
}
