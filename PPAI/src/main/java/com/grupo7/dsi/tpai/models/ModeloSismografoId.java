package com.grupo7.dsi.tpai.models;

import java.io.Serializable;
import java.util.Objects;

public class ModeloSismografoId implements Serializable {

    private String nombreModelo;

    private String nombreFabricante;

    public ModeloSismografoId() {
    }

    public ModeloSismografoId(String nombreModelo, String nombreFabricante) {
        this.nombreModelo = nombreModelo;
        this.nombreFabricante = nombreFabricante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModeloSismografoId)) return false;
        ModeloSismografoId that = (ModeloSismografoId) o;
        return Objects.equals(nombreModelo, that.nombreModelo) &&
                Objects.equals(nombreFabricante, that.nombreFabricante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreModelo, nombreFabricante);
    }

    // Getters y setters (opcional)
}
