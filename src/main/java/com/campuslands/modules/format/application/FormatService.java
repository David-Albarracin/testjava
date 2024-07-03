package com.campuslands.modules.format.application;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.format.domain.models.Format;
import com.campuslands.modules.format.domain.repository.FormatRepository;

/**
 * FormatService
 */
public class FormatService {

    private final FormatRepository repository;

    public FormatService(FormatRepository repository) {
        this.repository = repository;
    }

    public void createActor(Format data) {
        repository.save(data);
    }

    public void updateActor(Format data) {
        repository.update(data);
    }

    public Optional<Format> getActorById(int id) {
        return repository.findById(id);
    }

    public void deleteActor(int id) {
        repository.delete(id);
    }

    public List<Format> getAllActor() {
        return repository.findAll();
    }
}