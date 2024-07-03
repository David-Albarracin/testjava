package com.campuslands.modules.movieProtagonist.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.movieProtagonist.domain.models.MovieProtagonist;
import com.campuslands.modules.movieProtagonist.domain.repository.MovieProtagonistRepository;

/**
 * MovieProtagonistService
 */
public class MovieProtagonistService {

      private final MovieProtagonistRepository repository;

    public MovieProtagonistService(MovieProtagonistRepository repository) {
        this.repository = repository;
    }

    public void createMovieProtagonist(MovieProtagonist data) {
        repository.save(data);
    }

    public void updateMovieProtagonist(MovieProtagonist data) {
        repository.update(data);
    }

    public Optional<MovieProtagonist> getMovieProtagonistById(int id) {
        return repository.findById(id);
    }

    public void deleteMovieProtagonist(int id) {
        repository.delete(id);
    }

    public List<MovieProtagonist> getAllMovieProtagonist() {
        return repository.findAll();
    }
}