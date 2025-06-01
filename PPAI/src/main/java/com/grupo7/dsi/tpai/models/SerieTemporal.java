package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@IdClass(SerieTemporalId.class)
public class SerieTemporal {

    @Id
    private LocalDateTime fechaHoraRegistro;

    @Id
    private LocalDateTime fechaHoraInicioRegistroMuestras;

    private Boolean condicionAlarma;
    private Float frecuenciaMuestreo;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "estado_nombre", referencedColumnName = "nombre"),
            @JoinColumn(name = "estado_ambito", referencedColumnName = "ambito")
    })
    private Estado estado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "serie_temporal_fecha_hora_registro", referencedColumnName = "fechaHoraRegistro")
    private List<MuestraSismica> muestrasSismicas;

    public SerieTemporal() {
    }

    public SerieTemporal(Boolean condicionAlarma, LocalDateTime fechaHoraInicioRegistroMuestras, LocalDateTime fechaHoraRegistro, Float frecuenciaMuestreo, Estado estado, List<MuestraSismica> muestrasSismicas) {
        this.condicionAlarma = condicionAlarma;
        this.fechaHoraInicioRegistroMuestras = fechaHoraInicioRegistroMuestras;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.frecuenciaMuestreo = frecuenciaMuestreo;
        this.estado = estado;
        this.muestrasSismicas = muestrasSismicas;
    }

    public Boolean getCondicionAlarma() {
        return condicionAlarma;
    }

    public void setCondicionAlarma(Boolean condicionAlarma) {
        this.condicionAlarma = condicionAlarma;
    }

    public LocalDateTime getFechaHoraInicioRegistroMuestras() {
        return fechaHoraInicioRegistroMuestras;
    }

    public void setFechaHoraInicioRegistroMuestras(LocalDateTime fechaHoraInicioRegistroMuestras) {
        this.fechaHoraInicioRegistroMuestras = fechaHoraInicioRegistroMuestras;
    }

    public LocalDateTime getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Float getFrecuenciaMuestreo() {
        return frecuenciaMuestreo;
    }

    public void setFrecuenciaMuestreo(Float frecuenciaMuestreo) {
        this.frecuenciaMuestreo = frecuenciaMuestreo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<MuestraSismica> getMuestrasSismicas() {
        return muestrasSismicas;
    }

    public void setMuestrasSismicas(List<MuestraSismica> muestrasSismicas) {
        this.muestrasSismicas = muestrasSismicas;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerieTemporal that = (SerieTemporal) o;
        return Objects.equals(fechaHoraRegistro, that.fechaHoraRegistro)
                && Objects.equals(fechaHoraInicioRegistroMuestras, that.fechaHoraInicioRegistroMuestras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHoraRegistro, fechaHoraInicioRegistroMuestras);
    }
}
