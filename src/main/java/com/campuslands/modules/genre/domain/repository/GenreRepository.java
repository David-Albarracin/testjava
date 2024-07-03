package com.campuslands.modules.genre.domain.repository;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.genre.domain.models.Genre;

/**
 * GenreRepository
 */
public interface GenreRepository {

       void save(Genre data);
    void update(Genre data);
    Optional<Genre> findById(int id);
    void delete(int id);
    List<Genre> findAll();
}