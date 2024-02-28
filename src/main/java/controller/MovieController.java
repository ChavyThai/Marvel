package controller;


import dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MovieService;


@RestController
@RequestMapping("/movies")


public class MovieController {


    @Autowired
    MovieService movieService;


    @PostMapping
    public MovieDTO createPelicula(@RequestBody MovieDTO movie){
        return movieService.createMovie(movie);
    }


    @GetMapping("/{movieId}")
    public MovieDTO getMovieById(@PathVariable Integer movieId){
        return movieService.getMovieById(movieId);
    }


    @PutMapping("/{movieId}")
    public MovieDTO updateMovie(@RequestBody MovieDTO movie,
                                @PathVariable Integer movieId){
        return movieService.updateMovie(movie, movieId);
    }


    @DeleteMapping("/{movieId}")
    public void deleteById(@PathVariable Integer movieId){
        movieService.deleteMovieById(movieId);
    }
}