package pl.touk.recruitmenttask.ticketbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.touk.recruitmenttask.ticketbookingapp.model.Movie;
import pl.touk.recruitmenttask.ticketbookingapp.service.MovieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getSingleMovie(id);
    }
}
