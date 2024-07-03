package com.campuslands.modules.movieProtagonist.domain.models;


public class MovieProtagonist {

    private String movieProtagonistId;
    private int movieId;
    private int actorId;
    private int actorTypeId;


    
    public MovieProtagonist(int movieId, int actorId, int actorTypeId) {
        this.movieProtagonistId = String.valueOf(movieId) + String.valueOf(actorId);
        this.movieId = movieId;
        this.actorId = actorId;
        this.actorTypeId = actorTypeId;
    }

    public String getMovieProtagonistId() {
        return movieProtagonistId;
    }
    public void setMovieProtagonistId(String movieProtagonistId) {
        this.movieProtagonistId = movieProtagonistId;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public int getActorTypeId() {
        return actorTypeId;
    }
    public void setActorTypeId(int actorTypeId) {
        this.actorTypeId = actorTypeId;
    }

    
    
}