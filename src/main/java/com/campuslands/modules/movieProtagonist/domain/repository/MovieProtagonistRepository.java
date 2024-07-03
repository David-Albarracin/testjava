package com.campuslands.modules.movieProtagonist.domain.repository;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.movieProtagonist.domain.models.MovieProtagonist;

/**
 * MovieProtagonistRepository
 */
public interface MovieProtagonistRepository {

            void save(MovieProtagonist data);
    void update(MovieProtagonist data);
    Optional<MovieProtagonist> findById(int id);
    void delete(int id);
    List<MovieProtagonist> findAll();
}