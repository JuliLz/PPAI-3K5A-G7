package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ApreciacionTipo {

    @Id
    private String color;
    private String leyenda;

    public ApreciacionTipo() {
    }

    public ApreciacionTipo(String color, String leyenda) {
        this.color = color;
        this.leyenda = leyenda;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }
}
