package com.movietv.services;

import com.movietv.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MovieService.class)
public class MovieServiceTest {

    @MockitoBean
    private RestTemplate mockRestTemplate;

    @Autowired
    MovieService movieService;

    @Value("${api.key}")
    private String API_KEY;

    @Test
    public void testGetMovieList() throws Exception
    {
        when(mockRestTemplate.getForObject("https://api.themoviedb.org/3/trending/all/day?api_key="+API_KEY+"&language=en-US", String.class)).thenReturn(new TrendingMovie().movieList);
        List<Movie> movieList = movieService.getMovieList();

        assertAll("movieList",
                () -> assertFalse(movieList.isEmpty()),
                () -> assertEquals(movieList.getFirst().getTitle(), "exampleTitle")
        );

    }


    @Test
    public void testGetMovieTrailer() throws Exception
    {
        when(mockRestTemplate.getForObject("https://api.themoviedb.org/3/movie/"+ Integer.toString(0) +"/videos?api_key="+API_KEY, String.class)).thenReturn(new Trailer().trailerList);
        String trailerUrl = movieService.getMovieTrailer(Integer.toString(0));

        assertAll("movieTrailer",
                () -> assertEquals(trailerUrl, "https://www.youtube.com/embed/1234")
        );

    }


}
final class TrendingMovie {
    final String movieList;

    public TrendingMovie() {
        this.movieList = "{\n" +
                "  \"results\": [\n" +
                "\t\t{\n" +
                "\t\t  \"id\": 0,\n" +
                "\t\t  \"title\": \"exampleTitle\",\n" +
                "\t\t  \"poster_path\": \"/examplePosterPath\",\n" +
                "\t\t  \"original_language\": \"exampleLanguage\",\n" +
                "\t\t  \"original_title\": \"exampleTitle\",\n" +
                "\t\t  \"overview\": \"exampleOverview\",\n" +
                "\t\t  \"popularity\": 0.0,\n" +
                "\t\t  \"release_date\": \"2026-01-01\",\n" +
                "\t\t  \"vote_average\": 0.0,\n" +
                "\t\t  \"vote_count\": 0\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
    }

    // Override equals however you want here
}

final class Trailer {
    final String trailerList;

    public Trailer() {
        this.trailerList = "{\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"name\": \"exampleName\",\n" +
                "      \"key\": \"1234\",\n" +
                "      \"type\": \"Trailer\"" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

}
