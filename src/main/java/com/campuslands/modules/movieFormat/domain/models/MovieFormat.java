package com.campuslands.modules.movieFormat.domain.models;

/**
 * MovieFormat
 */
public class MovieFormat {

    private String movieFormatId;
    private int formatId;
    private int movieId;
    private int amount;

    
    public MovieFormat(int formatId, int movieId, int amount) {
        this.movieFormatId = String.valueOf(formatId) + String.valueOf(movieId);
        this.formatId = formatId;
        this.movieId = movieId;
        this.amount = amount;
    }

    public String getId() {
        return movieFormatId;
    }
    public void setMovieFormatId(String movieFormatId) {
        this.movieFormatId = movieFormatId;
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


    
}