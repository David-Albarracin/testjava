package com.campuslands.modules.actor.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.actor.domain.models.Actor;

/**
 * ActorRepository
 */
public interface ActorRepository {

    void save(Actor airlines);
    void update(Actor airlines);
    Optional<Actor> findById(int id);
    void delete(int id);
    List<Actor> findAll();

}