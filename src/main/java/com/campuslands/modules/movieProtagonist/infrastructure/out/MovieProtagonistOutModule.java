package com.campuslands.modules.movieProtagonist.infrastructure.out;

import com.campuslands.modules.movieProtagonist.application.MovieProtagonistService;
import com.campuslands.modules.movieProtagonist.infrastructure.in.MovieProtagonistAdapter;



public class MovieProtagonistOutModule {

    protected MovieProtagonistMySQL repository;
    protected MovieProtagonistService service;
    protected MovieProtagonistAdapter adapter;

    public MovieProtagonistOutModule() {
        repository = new MovieProtagonistMySQL();
        service = new MovieProtagonistService(repository);
        adapter = new MovieProtagonistAdapter(service);

    }

    public MovieProtagonistAdapter module() {
        return adapter;
    }
}
