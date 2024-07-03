package com.campuslands.modules.movieFormat.domain.models;

/**
 * MovieFormat
 */
public class MovieFormat {

    private String id;
    private int movieId;
    private int formatId;
    private int amount;

    
    public MovieFormat(int formatId, int movieId, int amount) {
        this.id = String.valueOf(formatId) + String.valueOf(movieId);
        this.formatId = formatId;
        this.movieId = movieId;
        this.amount = amount;
    }

    public MovieFormat() {
        //TODO Auto-generated constructor stub
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getFormatId() {
        return formatId;
    }
    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MovieFormat [id=" + id + ", movieId=" + movieId + ", formatId=" + formatId + ", amount=" + amount + "]";
    }

    
    
}