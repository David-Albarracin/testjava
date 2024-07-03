package com.campuslands.modules.typeActor.domain.models;


public class TypeActor {

    private int id;
    private String description;

    
    public TypeActor(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public TypeActor() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }
    public void setActorTypeId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeActor [id=" + id + ", description=" + description + "]";
    }
}