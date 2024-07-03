package com.campuslands.modules.typeActor.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.typeActor.domain.models.TypeActor;

/**
 * TypeActorRepository
 */
public interface TypeActorRepository {

             void save(TypeActor data);
    void update(TypeActor data);
    Optional<TypeActor> findById(int id);
    void delete(int id);
    List<TypeActor> findAll();
}