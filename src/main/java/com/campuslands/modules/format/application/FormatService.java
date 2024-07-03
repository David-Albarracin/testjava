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

    public void createFormat(Format data) {
        repository.save(data);
    }

    public void updateFormat(Format data) {
        repository.update(data);
    }

    public Optional<Format> getFormatById(int id) {
        return repository.findById(id);
    }

    public void deleteFormat(int id) {
        repository.delete(id);
    }

    public List<Format> getAllFormat() {
        return repository.findAll();
    }
}