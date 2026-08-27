package com.movietv.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movietv.model.Movie;
import com.movietv.utilities.JsonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_KEY = "<apikey>";
    private final String API_URL = "https://api.themoviedb.org/3/trending/all/day?api_key="+API_KEY+"&language=en-US";

    public List<Movie> getMovieList(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String responseResult =
                restTemplate.getForObject(API_URL, String.class);

        JsonElement responseResultJsonElement = JsonParser.parseString(responseResult);

        JsonObject responseResultJsonObject = responseResultJsonElement.getAsJsonObject();
        JsonElement resultsJsonElement = responseResultJsonObject.get("results");
        List<JsonElement> resultList = resultsJsonElement.getAsJsonArray().asList();
        List<Movie> movieList = new ArrayList<Movie>();
        resultList.forEach(result -> movieList.add(JsonProcessor.getInstance().deserializeJson(result.toString(),Movie.class)));

        return movieList;


    }
}
