package com.movietv.controller;

import com.movietv.model.Movie;
import com.movietv.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping({"/","/view-movie"})
    public ModelAndView viewMovie(ModelAndView model) {

        model.setViewName("view-movie");
        List<Movie> movieList = movieService.getMovieList();
        movieList.forEach(movie -> movie.setMovie_trailer(movieService.getMovieTrailer(movie.getId().toString())));

        model.addObject("movies", movieList);
        return model;
    }
}
