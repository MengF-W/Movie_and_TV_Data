package com.movietv.controller;

import com.movietv.model.Movie;
import com.movietv.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    MovieService movieService;

    @Test
    public void testSucceedRequestViewMovie() throws Exception {

        List<Movie> movieList = new ArrayList<Movie>();
        when(movieService.getMovieList()).thenReturn(movieList);

        mockMvc.perform(MockMvcRequestBuilders.get("/view-movie")
                        .accept(MediaType.TEXT_HTML))
                        .andExpect(status().isOk())
                        .andExpect(view().name("view-movie"))
                        .andExpect(model().attribute("movies", movieList));

    }
}
