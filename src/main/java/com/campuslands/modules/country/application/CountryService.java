package com.campuslands.modules.country.application;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.country.domain.models.Country;
import com.campuslands.modules.country.domain.repository.CountryRepository;

/**
 * CountryService
 */
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public void createCountry(Country data) {
        repository.save(data);
    }

    public void updateCountry(Country data) {
        repository.update(data);
    }

    public Optional<Country> getCountryById(int id) {
        return repository.findById(id);
    }

    public void deleteCountry(int id) {
        repository.delete(id);
    }

    public List<Country> getAllCountry() {
        return repository.findAll();
    }
    
}