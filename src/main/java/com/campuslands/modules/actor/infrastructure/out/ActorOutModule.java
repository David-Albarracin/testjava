package com.campuslands.modules.actor.infrastructure.out;

import com.campuslands.modules.actor.application.ActorService;
import com.campuslands.modules.actor.infrastructure.in.ActorAdapter;

public class ActorOutModule {

    protected ActorMySQL repository;
    protected ActorService service;
    protected ActorAdapter adapter;

     public ActorOutModule() {
        repository = new ActorMySQL();
        service = new ActorService(repository);
        adapter = new ActorAdapter(service);

    }

    public ActorAdapter module() {
        return adapter;
    }


}
