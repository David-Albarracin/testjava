package com.campuslands.modules.typeActor.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.typeActor.domain.models.TypeActor;
import com.campuslands.modules.typeActor.domain.repository.TypeActorRepository;

/**
 * TypeActorService
 */
public class TypeActorService {

      private final TypeActorRepository repository;

    public TypeActorService(TypeActorRepository repository) {
        this.repository = repository;
    }

    public void createTypeActor(TypeActor data) {
        repository.save(data);
    }

    public void updateTypeActor(TypeActor data) {
        repository.update(data);
    }

    public Optional<TypeActor> getTypeActorById(int id) {
        return repository.findById(id);
    }

    public void deleteTypeActor(int id) {
        repository.delete(id);
    }

    public List<TypeActor> getAllTypeActor() {
        return repository.findAll();
    }
}