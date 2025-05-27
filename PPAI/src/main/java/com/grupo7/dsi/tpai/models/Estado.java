package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

@Entity
@IdClass(EstadoId.class)
public class Estado {

    @Id
    private String nombre;

    @Id
    private String ambito;

    public Estado() {
    }

    public Estado(String nombre, String ambito) {
        this.nombre = nombre;
        this.ambito = ambito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Boolean estaPendienteRevision() {
        if (nombre == "Pendiente revisión" && ambito == "Evento sismico") {
            return true;
        }
        return false;
    }
}