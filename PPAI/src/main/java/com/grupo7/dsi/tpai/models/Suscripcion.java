package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraInicioSuscripcion;

    private LocalDateTime fechaHoraFinSuscripcion; // puede ser null

    @ManyToMany(fetch = FetchType.EAGER)
    private List<EstacionSismologica> estacionesSismologicas;

    public Suscripcion() {}

    public Suscripcion(LocalDateTime fechaHoraInicioSuscripcion, LocalDateTime fechaHoraFinSuscripcion) {
        this.fechaHoraInicioSuscripcion = fechaHoraInicioSuscripcion;
        this.fechaHoraFinSuscripcion = fechaHoraFinSuscripcion;
    }

    public Suscripcion(LocalDateTime fechaInicio, LocalDateTime fechaFin, List<EstacionSismologica> estacionesSismologicas) {
        this.fechaHoraInicioSuscripcion = fechaInicio;
        this.fechaHoraFinSuscripcion = fechaFin;
        this.estacionesSismologicas = estacionesSismologicas;
    }

    public boolean esVigente() {
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.isAfter(fechaHoraInicioSuscripcion) &&
                (fechaHoraFinSuscripcion == null || ahora.isBefore(fechaHoraFinSuscripcion));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraInicioSuscripcion() {
        return fechaHoraInicioSuscripcion;
    }

    public void setFechaHoraInicioSuscripcion(LocalDateTime fechaHoraInicioSuscripcion) {
        this.fechaHoraInicioSuscripcion = fechaHoraInicioSuscripcion;
    }

    public LocalDateTime getFechaHoraFinSuscripcion() {
        return fechaHoraFinSuscripcion;
    }

    public void setFechaHoraFinSuscripcion(LocalDateTime fechaHoraFinSuscripcion) {
        this.fechaHoraFinSuscripcion = fechaHoraFinSuscripcion;
    }

    public List<EstacionSismologica> getEstacionesSismologicas() {
        return estacionesSismologicas;
    }

    public void setEstacionesSismologicas(List<EstacionSismologica> estacionesSismologicas) {
        this.estacionesSismologicas = estacionesSismologicas;
    }
}
