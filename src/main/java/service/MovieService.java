package service;


import dto.MovieDTO;
import model.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MovieRepository;


import java.util.List;


@Service
public class MovieService {


    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }


    public MovieDTO createMovie(MovieDTO movieDTO){
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        movie = movieRepository.saveAndFlush(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }


    public MovieDTO getMovieById(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        return modelMapper.map(movie, MovieDTO.class);
    }


    public MovieDTO updateMovie(MovieDTO movie, Integer movieId){
        Movie oldMovie = movieRepository.findById(movieId).orElseThrow();
        oldMovie.setTitle(movie.getTitle());
        oldMovie.setImage(movie.getImage());
        oldMovie.setCalification(movie.getCalification());
        oldMovie = movieRepository.saveAndFlush(oldMovie);
        return modelMapper.map(oldMovie, MovieDTO.class);
    }


    public void deleteMovieById(Integer movieId){
        movieRepository.deleteById(movieId);
    }
}