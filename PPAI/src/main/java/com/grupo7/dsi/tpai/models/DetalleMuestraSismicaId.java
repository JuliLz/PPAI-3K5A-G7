package com.grupo7.dsi.tpai.models;

import java.io.Serializable;
import java.util.Objects;

public class DetalleMuestraSismicaId implements Serializable {

    private Float valor;
    private String tipoDeDato; // clave primaria de TipoDeDato

    public DetalleMuestraSismicaId() {}

    public DetalleMuestraSismicaId(Float valor, String tipoDeDato) {
        this.valor = valor;
        this.tipoDeDato = tipoDeDato;
    }

    // equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleMuestraSismicaId that)) return false;
        return Objects.equals(valor, that.valor) &&
                Objects.equals(tipoDeDato, that.tipoDeDato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, tipoDeDato);
    }
}
