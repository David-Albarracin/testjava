package com.campuslands.modules.typeActor.domain.models;


public class TypeActor {

    private int actorTypeId;
    private String description;

    
    public TypeActor(int actorTypeId, String description) {
        this.actorTypeId = actorTypeId;
        this.description = description;
    }

    public int getActorTypeId() {
        return actorTypeId;
    }
    public void setActorTypeId(int actorTypeId) {
        this.actorTypeId = actorTypeId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }




}