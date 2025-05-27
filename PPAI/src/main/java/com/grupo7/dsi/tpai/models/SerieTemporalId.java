package com.grupo7.dsi.tpai.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class SerieTemporalId implements Serializable {

    private LocalDateTime fechaHoraRegistro;
    private LocalDateTime fechaHoraInicioRegistroMuestras;

    public SerieTemporalId() {
    }

    public SerieTemporalId(LocalDateTime fechaHoraRegistro, LocalDateTime fechaHoraInicioRegistroMuestras) {
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.fechaHoraInicioRegistroMuestras = fechaHoraInicioRegistroMuestras;
    }

    // Getters y setters
    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public LocalDateTime getFechaHoraInicioRegistroMuestras() {
        return fechaHoraInicioRegistroMuestras;
    }

    public void setFechaHoraInicioRegistroMuestras(LocalDateTime fechaHoraInicioRegistroMuestras) {
        this.fechaHoraInicioRegistroMuestras = fechaHoraInicioRegistroMuestras;
    }

    // equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerieTemporalId)) return false;
        SerieTemporalId that = (SerieTemporalId) o;
        return Objects.equals(fechaHoraRegistro, that.fechaHoraRegistro) &&
                Objects.equals(fechaHoraInicioRegistroMuestras, that.fechaHoraInicioRegistroMuestras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHoraRegistro, fechaHoraInicioRegistroMuestras);
    }
}