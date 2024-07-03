package com.campuslands.modules.movie.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.movie.domain.models.Movie;
import com.campuslands.modules.movie.domain.repository.MovieRepository;

/**
 * MovieService
 */
public class MovieService {

      private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public void createMovie(Movie data) {
        repository.save(data);
    }

    public void updateMovie(Movie data) {
        repository.update(data);
    }

    public Optional<Movie> getMovieById(int id) {
        return repository.findById(id);
    }

    public void deleteMovie(int id) {
        repository.delete(id);
    }

    public List<Movie> getAllMovie() {
        return repository.findAll();
    }
}