package com.campuslands.modules.genre.domain.models;


public class Genre {

    private int genreId;
    private String descripcion;


    
    public Genre(int genreId, String descripcion) {
        this.genreId = genreId;
        this.descripcion = descripcion;
    }

    public Genre() {
		//TODO Auto-generated constructor stub
	}

	public int getGenreId() {
        return genreId;
    }
    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", descripcion=" + descripcion + "]";
    }

    
    
}