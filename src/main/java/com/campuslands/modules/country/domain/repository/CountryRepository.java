package com.campuslands.modules.country.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.country.domain.models.Country;


/**
 * CountryRepository
 */
public interface CountryRepository {

        void save(Country data);
    void update(Country data);
    Optional<Country> findById(int id);
    void delete(int id);
    List<Country> findAll();
}