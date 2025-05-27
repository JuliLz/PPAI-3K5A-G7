package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fabricante {

    @Id
    private String nombre;
    private String razonSocial;

    public Fabricante() {
    }

    public Fabricante(String nombre, String razonSocial) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }


}
