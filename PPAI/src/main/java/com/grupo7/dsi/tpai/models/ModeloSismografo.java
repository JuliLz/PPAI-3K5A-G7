package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

@Entity
@IdClass(ModeloSismografoId.class)
public class ModeloSismografo {

    @Id
    private String nombreModelo;

    @Id
    @Column(name = "nombreFabricante")
    private String nombreFabricante;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "nombreFabricante", referencedColumnName = "nombre", insertable = false, updatable = false)
    private Fabricante fabricante;

    private String descripcion;
    private String especificacionesTecnicas;

    public ModeloSismografo() {
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspecificacionesTecnicas() {
        return especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(String especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }
}
