package com.campuslands.modules.genre.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.genre.domain.models.Genre;
import com.campuslands.modules.genre.domain.repository.GenreRepository;

/**
 * GenreService
 */
public class GenreService {

     private final GenreRepository repository;

    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    public void createGenre(Genre data) {
        repository.save(data);
    }

    public void updateGenre(Genre data) {
        repository.update(data);
    }

    public Optional<Genre> getGenreById(int id) {
        return repository.findById(id);
    }

    public void deleteGenre(int id) {
        repository.delete(id);
    }

    public List<Genre> getAllGenre() {
        return repository.findAll();
    }
}