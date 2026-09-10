package com.movietv.services.api;

import com.movietv.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieApiService.class)
public class MovieApiServiceTest {
    @MockitoBean
    private MovieService mockMovieService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMovieTrend() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/movie/view-movie")
                        .contentType(""))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }
}