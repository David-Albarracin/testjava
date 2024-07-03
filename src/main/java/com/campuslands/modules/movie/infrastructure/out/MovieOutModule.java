package com.campuslands.modules.movie.infrastructure.out;

import com.campuslands.modules.movie.application.MovieService;
import com.campuslands.modules.movie.infrastructure.in.MovieAdapter;



public class MovieOutModule {
    protected MovieMySQL repository;
    protected MovieService service;
    protected MovieAdapter adapter;

     public MovieOutModule() {
        repository = new MovieMySQL();
        service = new MovieService(repository);
        adapter = new MovieAdapter(service);

    }

    public MovieAdapter module() {
        return adapter;
    }

    public void infoMovie(){
        repository.findDetailedInfoById(adapter.getId());

        
    }

    public void infoMovieActors(){
        
        service.getMovieById(adapter.getId());
        
    }

}
