package com.grupo7.dsi.tpai.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class CambioEstadoId implements Serializable {

    private LocalDateTime fechaHoraInicio;
    private String estadoNombre;
    private String estadoAmbito;

    // constructor vacío
    public CambioEstadoId() {}

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CambioEstadoId)) return false;
        CambioEstadoId that = (CambioEstadoId) o;
        return Objects.equals(fechaHoraInicio, that.fechaHoraInicio) &&
                Objects.equals(estadoNombre, that.estadoNombre) &&
                Objects.equals(estadoAmbito, that.estadoAmbito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHoraInicio, estadoNombre, estadoAmbito);
    }

    // getters & setters
}