package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MagnitudRichter {

    @Id
    private Float numero;
    private String descripcionMagnitud;

    public MagnitudRichter() {
    }

    public MagnitudRichter(Float numero, String descripcionMagnitud) {
        this.descripcionMagnitud = descripcionMagnitud;
        this.numero = numero;
    }

    public String getDescripcionMagnitud() {
        return descripcionMagnitud;
    }

    public void setDescripcionMagnitud(String descripcionMagnitud) {
        this.descripcionMagnitud = descripcionMagnitud;
    }

    public Float getNumero() {
        return numero;
    }

    public void setNumero(Float numero) {
        this.numero = numero;
    }
}
