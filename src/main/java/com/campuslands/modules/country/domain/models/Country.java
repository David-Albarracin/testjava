package com.campuslands.modules.country.domain.models;


public class Country {

    private int countryId;
    private String name;
    private String nationality;


    
    public Country(int countryId, String name, String nationality) {
        this.countryId = countryId;
        this.name = name;
        this.nationality = nationality;
    }


    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getNationality() {
        return nationality;
    }


    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    
    
}