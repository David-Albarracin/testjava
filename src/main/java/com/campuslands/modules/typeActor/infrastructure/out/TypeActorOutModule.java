package com.campuslands.modules.typeActor.infrastructure.out;

import com.campuslands.modules.typeActor.application.TypeActorService;
import com.campuslands.modules.typeActor.infrastructure.in.TypeActorAdapter;



public class TypeActorOutModule {
       protected TypeActorMySQL repository;
    protected TypeActorService service;
    protected TypeActorAdapter adapter;

     public TypeActorOutModule() {
        repository = new TypeActorMySQL();
        service = new TypeActorService(repository);
        adapter = new TypeActorAdapter(service);

    }

    public TypeActorAdapter module() {
        return adapter;
    }
}
