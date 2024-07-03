package com.campuslands.modules.country.infrastructure.out;


import com.campuslands.modules.country.application.CountryService;
import com.campuslands.modules.country.infrastructure.in.CountryAdapter;

public class CountryOutModule {

    protected CountryMySQL repository;
    protected CountryService service;
    protected CountryAdapter adapter;

     public CountryOutModule() {
        repository = new CountryMySQL();
        service = new CountryService(repository);
        adapter = new CountryAdapter(service);

    }

    public CountryAdapter module() {
        return adapter;
    }
    
}
