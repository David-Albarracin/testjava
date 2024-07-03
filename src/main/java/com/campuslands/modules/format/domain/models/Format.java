package com.campuslands.modules.format.domain.models;

public class Format {

    private int formatId;
    private String descripcion;

    public Format(){}    

    
    public Format(int formatId, String descripcion) {
        this.formatId = formatId;
        this.descripcion = descripcion;
    }

    public int getFormatId() {
        return formatId;
    }
    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Format [formatId=" + formatId + ", descripcion=" + descripcion + "]";
    }


    
}