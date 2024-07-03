package com.campuslands.modules.country.domain.models;


public class Country {

    private int countryId;
    private String descripcion;

    public Country(){}
    
    public Country(int countryId, String descripcion) {
        this.countryId = countryId;
        this.descripcion = descripcion;
    }


    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Country [countryId=" + countryId + ", descripcion=" + descripcion + "]";
    }
}