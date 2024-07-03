package com.campuslands.modules.movieFormat.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.movieFormat.domain.models.MovieFormat;



/**
 * MovieFormatRepository
 */
public interface MovieFormatRepository {

          void save(MovieFormat data);
    void update(MovieFormat data);
    Optional<MovieFormat> findById(int id);
    void delete(int id);
    List<MovieFormat> findAll();
}