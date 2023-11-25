package com.example.comp1011st1200409a2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APIUtility {

    public static CountryInfo[] callAPI(String countryName) throws IOException, InterruptedException {
        countryName = countryName.replaceAll(" ","%20");

        String uri = "https://restcountries.com/v3.1/name/"+countryName;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

//        HttpResponse<Path> httpResponse = client.send(httpRequest,HttpResponse
//                .BodyHandlers
//                .ofFile(Paths.get("moreCountries.json")));

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse
                .BodyHandlers
                .ofString());

        Gson gson = new Gson();

        return gson.fromJson(httpResponse.body(), CountryInfo[].class);
    }
}
