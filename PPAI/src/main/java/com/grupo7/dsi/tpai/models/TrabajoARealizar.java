package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TrabajoARealizar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comentario;
    private LocalDate fechaFinPrevista;
    private LocalDate fechaFinReal;
    private LocalDate fechaInicioPrevista;
    private LocalDate fechaInicioReal;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_trabajo_id")
    private TipoTrabajo definicionTrabajo;

    public TrabajoARealizar() {}

    public TrabajoARealizar(String comentario, LocalDate fechaFinPrevista, LocalDate fechaFinReal, LocalDate fechaInicioPrevista, LocalDate fechaInicioReal, TipoTrabajo definicionTrabajo) {
        this.comentario = comentario;
        this.fechaFinPrevista = fechaFinPrevista;
        this.fechaFinReal = fechaFinReal;
        this.fechaInicioPrevista = fechaInicioPrevista;
        this.fechaInicioReal = fechaInicioReal;
        this.definicionTrabajo = definicionTrabajo;
    }

    // estaFinalizado()

    public boolean estaFinalizado() {
        return fechaFinReal != null;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaFinPrevista() {
        return fechaFinPrevista;
    }

    public void setFechaFinPrevista(LocalDate fechaFinPrevista) {
        this.fechaFinPrevista = fechaFinPrevista;
    }

    public LocalDate getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(LocalDate fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    public LocalDate getFechaInicioPrevista() {
        return fechaInicioPrevista;
    }

    public void setFechaInicioPrevista(LocalDate fechaInicioPrevista) {
        this.fechaInicioPrevista = fechaInicioPrevista;
    }

    public LocalDate getFechaInicioReal() {
        return fechaInicioReal;
    }

    public void setFechaInicioReal(LocalDate fechaInicioReal) {
        this.fechaInicioReal = fechaInicioReal;
    }

    public TipoTrabajo getDefinicionTrabajo() {
        return definicionTrabajo;
    }

    public void setDefinicionTrabajo(TipoTrabajo definicionTrabajo) {
        this.definicionTrabajo = definicionTrabajo;
    }


}
