
package com.campuslands.modules.actor.domain.models;

/**
 * Actor
 */
public class Actor {
    
    int actorId;
    String name;
    int age;
    int countryId;
    int genreId;


    public Actor() {}

    public Actor(int actorId, String name, int age, int countryId, int genreId) {
        this.actorId = actorId;
        this.name = name;
        this.age = age;
        this.countryId = countryId;
        this.genreId = genreId;
    }

    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public int getGenreId() {
        return genreId;
    }
    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Actor [actorId=" + actorId + ", name=" + name + ", age=" + age + ", countryId=" + countryId
                + ", genreId=" + genreId + "]";
    }
    
}