package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TipoDeDato {

    @Id
    private String denominacion;
    private String nombreUnidadMedida;
    private Float valorUmbral;

    public TipoDeDato() {
    }

    public TipoDeDato(String denominacion, String nombreUnidadMedida, Float valorUmbral) {
        this.denominacion = denominacion;
        this.nombreUnidadMedida = nombreUnidadMedida;
        this.valorUmbral = valorUmbral;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public Float getValorUmbral() {
        return valorUmbral;
    }

    public void setValorUmbral(Float valorUmbral) {
        this.valorUmbral = valorUmbral;
    }

    @Override
    public String toString() {
        return "TipoDeDato{" +
                "denominacion='" + denominacion + '\'' +
                ", nombreUnidadMedida='" + nombreUnidadMedida + '\'' +
                ", valorUmbral=" + valorUmbral +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDeDato)) return false;

        TipoDeDato that = (TipoDeDato) o;

        if (!denominacion.equals(that.denominacion)) return false;
        if (!nombreUnidadMedida.equals(that.nombreUnidadMedida)) return false;
        return valorUmbral.equals(that.valorUmbral);
    }

    public boolean esTuDenominacion(String denominacion) {
        return this.denominacion.equals(denominacion);
    }


}
