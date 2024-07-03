package com.campuslands.modules.movieFormat.infrastructure.out;

import com.campuslands.modules.movieFormat.application.MovieFormatService;
import com.campuslands.modules.movieFormat.infrastructure.in.MovieFormatAdapter;



public class MovieFormatOutModule {
       protected MovieFormatMySQL repository;
    protected MovieFormatService service;
    protected MovieFormatAdapter adapter;

     public MovieFormatOutModule() {
        repository = new MovieFormatMySQL();
        service = new MovieFormatService(repository);
        adapter = new MovieFormatAdapter(service);

    }

    public MovieFormatAdapter module() {
        return adapter;
    }
}
