package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rol {

    @Id
    private String nombre;
    private String descripcionRol;

    public Rol() {
    }

    public Rol(String descripcionRol, String nombre) {
        this.descripcionRol = descripcionRol;
        this.nombre = nombre;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
