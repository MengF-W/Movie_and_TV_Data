package com.movietv.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movietv.model.Movie;
import com.movietv.utilities.JsonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Value("${api.url}")
    private String API_URL;
    public List<Movie> getMovieList(){

        String responseResult =
                restTemplate.getForObject(API_URL, String.class);

        JsonElement responseResultJsonElement = JsonParser.parseString(responseResult);

        JsonObject responseResultJsonObject = responseResultJsonElement.getAsJsonObject();
        JsonElement resultsJsonElement = responseResultJsonObject.get("results");
        List<JsonElement> resultList = resultsJsonElement.getAsJsonArray().asList();
        List<Movie> movieList = new ArrayList<Movie>();
        resultList.forEach(result -> appendMovieList(result,movieList));

        return movieList;
    }

    public void appendMovieList(JsonElement result, List<Movie> movieList){
        final String IMAGE_URL = "https://image.tmdb.org/t/p/w154";

        Movie movie = JsonProcessor.getInstance().deserializeJson(result.toString(),Movie.class);
        movie.setThumbnail_poster(IMAGE_URL+movie.getPoster_path());
        movieList.add(movie);

    }
}
