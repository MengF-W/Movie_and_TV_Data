package com.movietv.services.api;

import com.movietv.datatransferobject.MovieDTO;
import com.movietv.model.Movie;
import com.movietv.services.MovieService;
import com.movietv.utilities.JsonProcessor;
import com.movietv.utilities.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/movie")
public class MovieApiService {

    @Autowired
    MovieService movieService;


    @GetMapping(path = "/view-movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMovieTrend() {

        List<Movie> movieList = movieService.getMovieList();
        movieList.forEach(movie -> movie.setMovie_trailer(movieService.getMovieTrailer(movie.getId().toString())));
        List<MovieDTO> movieDtoList = new ArrayList<>();

        movieList.forEach(movie -> {
            movieDtoList.add(MovieMapper.getInstance().mapToDTO(movie));
        });
        Map<String,List<MovieDTO>> movieDtoMap = new HashMap<>();
        movieDtoMap.put("result",movieDtoList);

        return JsonProcessor.getInstance().serializeJson(movieDtoMap);
    }

}
