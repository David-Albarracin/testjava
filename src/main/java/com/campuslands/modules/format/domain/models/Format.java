package com.campuslands.modules.format.domain.models;

public class Format {

    private int formatId;
    private String name;

    
    public Format(int formatId, String name) {
        this.formatId = formatId;
        this.name = name;
    }

    public int getFormatId() {
        return formatId;
    }
    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    
}