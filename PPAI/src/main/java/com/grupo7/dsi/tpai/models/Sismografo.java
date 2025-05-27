package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Sismografo {

    @Id
    private Integer identificadorSismografo;

    private Integer nroSerie;
    private LocalDate fechaAdquisicion;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "nombreModelo", referencedColumnName = "nombreModelo"),
            @JoinColumn(name = "nombreFabricante", referencedColumnName = "nombreFabricante")
    })
    private ModeloSismografo modelo;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "serie_fecha_hora_registro", referencedColumnName = "fechaHoraRegistro"),
            @JoinColumn(name = "serie_fecha_hora_inicio", referencedColumnName = "fechaHoraInicioRegistroMuestras")
    })
    private SerieTemporal serieTemporal;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "estado_nombre", referencedColumnName = "nombre"),
            @JoinColumn(name = "estado_ambito", referencedColumnName = "ambito")
    })
    private Estado estadoActual;

    @OneToMany(mappedBy = "sismografo", cascade = CascadeType.ALL)
    private List<CambioEstado> cambiosEstado;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sismografo_id") // este campo se creará en la tabla Reparacion
    private List<Reparacion> reparaciones;

    @OneToOne(mappedBy = "sismografoAsignado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PlanConstruccionES planesConstruccionES;

    public Sismografo() {
    }

    public Sismografo(Integer identificadorSismografo, Integer nroSerie, LocalDate fechaAdquisicion, ModeloSismografo modelo, SerieTemporal serieTemporal, Estado estadoActual, List<CambioEstado> cambiosEstado, List<Reparacion> reparaciones, PlanConstruccionES planesConstruccionES) {
        this.identificadorSismografo = identificadorSismografo;
        this.nroSerie = nroSerie;
        this.fechaAdquisicion = fechaAdquisicion;
        this.modelo = modelo;
        this.serieTemporal = serieTemporal;
        this.estadoActual = estadoActual;
        this.cambiosEstado = cambiosEstado;
        this.reparaciones = reparaciones;
        this.planesConstruccionES = planesConstruccionES;
    }

    public Integer getIdentificadorSismografo() {
        return identificadorSismografo;
    }

    public void setIdentificadorSismografo(Integer identificadorSismografo) {
        this.identificadorSismografo = identificadorSismografo;
    }

    public Integer getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(Integer nroSerie) {
        this.nroSerie = nroSerie;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public ModeloSismografo getModelo() {
        return modelo;
    }

    public void setModelo(ModeloSismografo modelo) {
        this.modelo = modelo;
    }

    public SerieTemporal getSerieTemporal() {
        return serieTemporal;
    }

    public void setSerieTemporal(SerieTemporal serieTemporal) {
        this.serieTemporal = serieTemporal;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public List<CambioEstado> getCambiosEstado() {
        return cambiosEstado;
    }

    public void setCambiosEstado(List<CambioEstado> cambiosEstado) {
        this.cambiosEstado = cambiosEstado;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public PlanConstruccionES getPlanesConstruccionES() {
        return planesConstruccionES;
    }

    public void setPlanesConstruccionES(PlanConstruccionES planesConstruccionES) {
        this.planesConstruccionES = planesConstruccionES;
    }
}
