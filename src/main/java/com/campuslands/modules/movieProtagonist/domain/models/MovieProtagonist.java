package com.campuslands.modules.movieProtagonist.domain.models;


public class MovieProtagonist {

    private String id;
    private int movieId;
    private int actorId;
    private int actorTypeId;


    
    public MovieProtagonist(int movieId, int actorId, int actorTypeId) {
        this.id = String.valueOf(movieId) + String.valueOf(actorId);
        this.movieId = movieId;
        this.actorId = actorId;
        this.actorTypeId = actorTypeId;
    }

    public MovieProtagonist() {
		//TODO Auto-generated constructor stub
	}

	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "MovieProtagonist [id=" + id + ", movieId=" + movieId + ", actorId=" + actorId + ", actorTypeId="
                + actorTypeId + "]";
    }

    
    
    
}