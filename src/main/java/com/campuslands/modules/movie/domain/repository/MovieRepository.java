package com.campuslands.modules.movie.domain.repository;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.movie.domain.models.Movie;

/**
 * MovieRepository
 */
public interface MovieRepository {

         void save(Movie data);
    void update(Movie data);
    Optional<Movie> findById(int id);
    void delete(int id);
    List<Movie> findAll();

    
    
}