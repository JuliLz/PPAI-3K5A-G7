package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nroReparacion;
    private String comentariosReparacion;
    private String comentariosResolucionReparacion;
    private LocalDate fechaEnvioReparacion;
    private LocalDate fechaRespuestaReparacion;

    public Reparacion() {
    }

    public Reparacion(String comentariosReparacion, String comentariosResolucionReparacion, LocalDate fechaEnvioReparacion, LocalDate fechaRespuestaReparacion, Integer nroReparacion) {
        this.comentariosReparacion = comentariosReparacion;
        this.comentariosResolucionReparacion = comentariosResolucionReparacion;
        this.fechaEnvioReparacion = fechaEnvioReparacion;
        this.fechaRespuestaReparacion = fechaRespuestaReparacion;
        this.nroReparacion = nroReparacion;
    }

    public String getComentariosReparacion() {
        return comentariosReparacion;
    }

    public void setComentariosReparacion(String comentariosReparacion) {
        this.comentariosReparacion = comentariosReparacion;
    }

    public String getComentariosResolucionReparacion() {
        return comentariosResolucionReparacion;
    }

    public void setComentariosResolucionReparacion(String comentariosResolucionReparacion) {
        this.comentariosResolucionReparacion = comentariosResolucionReparacion;
    }

    public LocalDate getFechaEnvioReparacion() {
        return fechaEnvioReparacion;
    }

    public void setFechaEnvioReparacion(LocalDate fechaEnvioReparacion) {
        this.fechaEnvioReparacion = fechaEnvioReparacion;
    }

    public LocalDate getFechaRespuestaReparacion() {
        return fechaRespuestaReparacion;
    }

    public void setFechaRespuestaReparacion(LocalDate fechaRespuestaReparacion) {
        this.fechaRespuestaReparacion = fechaRespuestaReparacion;
    }

    public Integer getNroReparacion() {
        return nroReparacion;
    }

    public void setNroReparacion(Integer nroReparacion) {
        this.nroReparacion = nroReparacion;
    }
}
