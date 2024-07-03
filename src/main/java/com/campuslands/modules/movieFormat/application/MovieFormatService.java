package com.campuslands.modules.movieFormat.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.movieFormat.domain.models.MovieFormat;
import com.campuslands.modules.movieFormat.domain.repository.MovieFormatRepository;

/**
 * MovieFormatService
 */
public class MovieFormatService {

      private final MovieFormatRepository repository;

    public MovieFormatService(MovieFormatRepository repository) {
        this.repository = repository;
    }

    public void createMovieFormat(MovieFormat data) {
        repository.save(data);
    }

    public void updateMovieFormat(MovieFormat data) {
        repository.update(data);
    }

    public Optional<MovieFormat> getMovieFormatById(int id) {
        return repository.findById(id);
    }

    public void deleteMovieFormat(int id) {
        repository.delete(id);
    }

    public List<MovieFormat> getAllMovieFormat() {
        return repository.findAll();
    }
}