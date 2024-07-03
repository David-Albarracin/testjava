package com.campuslands.modules.actor.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.actor.domain.models.Actor;
import com.campuslands.modules.actor.domain.repository.ActorRepository;

/**
 * ActorService
 */
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void createActor(Actor actor) {
        actorRepository.save(actor);
    }

    public void updateActor(Actor actor) {
        actorRepository.update(actor);
    }

    public Optional<Actor> getActorById(int id) {
        return actorRepository.findById(id);
    }

    public void deleteActor(int id) {
        actorRepository.delete(id);
    }

    public List<Actor> getAllActor() {
        return actorRepository.findAll();
    }

    
}