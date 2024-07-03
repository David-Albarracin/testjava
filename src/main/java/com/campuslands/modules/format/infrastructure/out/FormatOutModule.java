package com.campuslands.modules.format.infrastructure.out;

import com.campuslands.modules.format.application.FormatService;
import com.campuslands.modules.format.infrastructure.in.FormatAdapter;


public class FormatOutModule {

        protected FormatMySQL repository;
    protected FormatService service;
    protected FormatAdapter adapter;

     public FormatOutModule() {
        repository = new FormatMySQL();
        service = new FormatService(repository);
        adapter = new FormatAdapter(service);

    }

    public FormatAdapter module() {
        return adapter;
    }
}
