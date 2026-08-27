package com.movietv.controller;

import com.movietv.model.Movie;
import com.movietv.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/view-movie")
    public ModelAndView viewBooks(ModelAndView model) {

        model.setViewName("view-movie");
        model.addObject("movies", movieService.getMovieList());
        return model;
    }
}
