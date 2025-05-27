package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TareaAsignada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comentario;

    private LocalDateTime fechaHoraRealizacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tarea_id") // Nombre de la FK en la tabla
    private TipoTareaInspeccion tarea;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "apreciacion_id") // Nombre de la FK en la tabla
    private ApreciacionTipo apreciacion;

    public TareaAsignada() {}

    public TareaAsignada(String comentario, LocalDateTime fechaHoraRealizacion, TipoTareaInspeccion tarea, ApreciacionTipo apreciacion) {
        this.comentario = comentario;
        this.fechaHoraRealizacion = fechaHoraRealizacion;
        this.tarea = tarea;
        this.apreciacion = apreciacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaHoraRealizacion() {
        return fechaHoraRealizacion;
    }

    public void setFechaHoraRealizacion(LocalDateTime fechaHoraRealizacion) {
        this.fechaHoraRealizacion = fechaHoraRealizacion;
    }

    public TipoTareaInspeccion getTarea() {
        return tarea;
    }

    public void setTarea(TipoTareaInspeccion tarea) {
        this.tarea = tarea;
    }

    public ApreciacionTipo getApreciacion() {
        return apreciacion;
    }

    public void setApreciacion(ApreciacionTipo apreciacion) {
        this.apreciacion = apreciacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
