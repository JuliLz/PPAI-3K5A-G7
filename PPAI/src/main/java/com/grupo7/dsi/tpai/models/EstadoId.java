package com.grupo7.dsi.tpai.models;

import java.io.Serializable;
import java.util.Objects;

public class EstadoId implements Serializable {

    private String nombre;
    private String ambito;

    public EstadoId() {}

    public EstadoId(String nombre, String ambito) {
        this.nombre = nombre;
        this.ambito = ambito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadoId)) return false;
        EstadoId that = (EstadoId) o;
        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(ambito, that.ambito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ambito);
    }

    // getters & setters
}