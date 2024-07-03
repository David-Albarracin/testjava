package com.campuslands.modules.movie.domain.models;

/**
 * Movie
 */
public class Movie {

    private int movieId;
    private String code;
    private String name;
    private String duration;
    private String sinopsis;

    
    public Movie(int movieId, String code, String name, String duration, String sinopsis) {
        this.movieId = movieId;
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.sinopsis = sinopsis;
    }

    public Movie() {
        //TODO Auto-generated constructor stub
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", code=" + code + ", name=" + name + ", duration=" + duration
                + ", sinopsis=" + sinopsis + "]";
    }


    

    


    
}