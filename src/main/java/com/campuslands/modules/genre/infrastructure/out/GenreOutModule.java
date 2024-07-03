package com.campuslands.modules.genre.infrastructure.out;

import com.campuslands.modules.genre.application.GenreService;
import com.campuslands.modules.genre.infrastructure.in.GenreAdapter;


public class GenreOutModule {
    
    protected GenreMySQL repository;
    protected GenreService service;
    protected GenreAdapter adapter;

     public GenreOutModule() {
        repository = new GenreMySQL();
        service = new GenreService(repository);
        adapter = new GenreAdapter(service);

    }

    public GenreAdapter module() {
        return adapter;
    }
}
