package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

@Entity
public class MotivoFueraServicio {

    @Id
    private String comentario;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "motivo_tipo_descripcion", referencedColumnName = "descripcion")
    private MotivoTipo motivoTipo;

    public MotivoFueraServicio() {
    }

    public MotivoFueraServicio(String comentario, MotivoTipo motivoTipo) {
        this.comentario = comentario;
        this.motivoTipo = motivoTipo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public MotivoTipo getMotivoTipo() {
        return motivoTipo;
    }

    public void setMotivoTipo(MotivoTipo motivoTipo) {
        this.motivoTipo = motivoTipo;
    }
}
