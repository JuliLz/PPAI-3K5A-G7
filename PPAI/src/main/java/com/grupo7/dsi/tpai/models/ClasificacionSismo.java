package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClasificacionSismo {

    @Id
    private String nombre;
    private Float kmProfundidadDesde;
    private Float kmProfundidadHasta;

    public ClasificacionSismo() {
    }

    public ClasificacionSismo(Float kmProfundidadDesde, Float kmProfundidadHasta, String nombre) {
        this.kmProfundidadDesde = kmProfundidadDesde;
        this.kmProfundidadHasta = kmProfundidadHasta;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getKmProfundidadDesde() {
        return kmProfundidadDesde;
    }

    public void setKmProfundidadDesde(Float kmProfundidadDesde) {
        this.kmProfundidadDesde = kmProfundidadDesde;
    }

    public Float getKmProfundidadHasta() {
        return kmProfundidadHasta;
    }

    public void setKmProfundidadHasta(Float kmProfundidadHasta) {
        this.kmProfundidadHasta = kmProfundidadHasta;
    }
}
