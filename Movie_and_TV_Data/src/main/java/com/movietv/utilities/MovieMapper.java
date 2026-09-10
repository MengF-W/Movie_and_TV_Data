package com.movietv.utilities;

import com.movietv.datatransferobject.MovieDTO;
import com.movietv.model.Movie;
import org.springframework.stereotype.Component;

public class MovieMapper {

    private static MovieMapper movieMapper;
    private MovieMapper(){}

    public static MovieMapper getInstance() {

        if(movieMapper == null){

            movieMapper = new MovieMapper();

        }

        return movieMapper;
    }
    public MovieDTO mapToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setLanguage(movie.getOriginal_language());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setName(movie.getName());
        movieDTO.setMovie_poster(movie.getThumbnail_poster());
        movieDTO.setMovie_trailer(movie.getMovie_trailer());
        movieDTO.setOverview(movie.getOverview());
        movieDTO.setPopularity(movie.getPopularity());
        movieDTO.setRelease_date(movie.getRelease_date());
        movieDTO.setFirst_air_date(movie.getFirst_air_date());
        movieDTO.setVote_average(movie.getVote_average());
        movieDTO.setVote_count(movie.getVote_count());

        return movieDTO;

    }

}
