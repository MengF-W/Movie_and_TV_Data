package com.movietv.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.movietv.model.Movie;
import com.movietv.utilities.JsonProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String API_KEY;
    public List<Movie> getMovieList(){

        List<Movie> movieList = new ArrayList<>();

        try{
            final String TRENDING_MOVIE_URL = "https://api.themoviedb.org/3/trending/all/day?api_key="+API_KEY+"&language=en-US";

            String responseResult =
                    restTemplate.getForObject(TRENDING_MOVIE_URL, String.class);

            List<JsonElement> resultList = JsonParser.parseString(responseResult).getAsJsonObject().get("results").getAsJsonArray().asList();

            resultList.forEach(result -> {
                final String IMAGE_URL = "https://image.tmdb.org/t/p/w154";

                Movie movie = JsonProcessor.getInstance().deserializeJson(result.toString(),Movie.class);
                movie.setThumbnail_poster(IMAGE_URL+movie.getPoster_path());
                movieList.add(movie);
            });

        }catch(HttpClientErrorException e)
        {
            e.printStackTrace();
        }

        return movieList;
    }


    public String getMovieTrailer(String movieId){

        final String VIDEO_URL ="https://api.themoviedb.org/3/movie/"+ movieId +"/videos?api_key="+API_KEY;
        final String YOUTUBE_URL ="https://www.youtube.com/embed/";
        AtomicReference<String> MOVIE_TRAILER_URL = new AtomicReference<>("");

        try{
            String responseResult =
                    restTemplate.getForObject(VIDEO_URL, String.class);

            List<JsonElement> resultList = JsonParser.parseString(responseResult).getAsJsonObject().get("results").getAsJsonArray().asList();

            resultList
                    .stream()
                    .filter(result -> result.getAsJsonObject().get("type").toString().contains("Trailer"))
                    .forEach(result -> MOVIE_TRAILER_URL.set(YOUTUBE_URL + result.getAsJsonObject().get("key").getAsString()));
        }
        catch (HttpClientErrorException e){
            MOVIE_TRAILER_URL.set("");
        }

        return MOVIE_TRAILER_URL.get();
    }
}
