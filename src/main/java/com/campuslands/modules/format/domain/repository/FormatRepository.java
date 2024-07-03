package com.campuslands.modules.format.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.format.domain.models.Format;

/**
 * FormatRepository
 */
public interface FormatRepository {

    void save(Format data);
    void update(Format data);
    Optional<Format> findById(int id);
    void delete(int id);
    List<Format> findAll();

}