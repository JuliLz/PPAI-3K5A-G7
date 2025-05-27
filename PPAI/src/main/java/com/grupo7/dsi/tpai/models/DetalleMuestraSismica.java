package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

@Entity
@IdClass(DetalleMuestraSismicaId.class)
public class DetalleMuestraSismica {

    @Id
    private Float valor;

    @Id
    @ManyToOne
    @JoinColumn(name = "tipo_de_dato", referencedColumnName = "denominacion", nullable = false) // o el campo PK real
    private TipoDeDato tipoDeDato;

    // Otros atributos si querés...

    public DetalleMuestraSismica() {}

    public DetalleMuestraSismica(Float valor, TipoDeDato tipoDeDato) {
        this.valor = valor;
        this.tipoDeDato = tipoDeDato;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public TipoDeDato getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(TipoDeDato tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }
}