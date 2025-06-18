package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("Beetlejuice", "Tim Burton", 1988, 92));
        add(new Movie("Coraline", "Tim Burton", 2009, 101));
        add(new Movie("The Nightmare Before Christmas", "Tim Burton", 1993, 76 ));
    }};

    @GetMapping("/json")
    public List<Movie> getMoviesJson() { return movies; }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + ", " + movie.getDirector() + ", " + movie.getYear() + ", " + movie.getRuntime() + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }

}
