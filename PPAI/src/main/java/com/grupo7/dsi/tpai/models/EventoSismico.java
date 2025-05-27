package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@IdClass(EventoSismicoId.class)
public class EventoSismico {

    @Id
    private LocalDateTime fechaHoraOcurrencia;

    @Id
    @ManyToOne
    @JoinColumn(name = "origenGeneracion", referencedColumnName = "nombre")
    private OrigenDeGeneracion origenGeneracion;

    private LocalDateTime fechaHoraFin;
    private String latitudEpicentro;
    private String latitudHipocentro;
    private String longitudEpicentro;
    private String longitudHipocentro;
    private Float valorMagnitud;

    @ManyToOne
    @JoinColumn(name = "magnitud_richter", referencedColumnName = "numero")
    private MagnitudRichter magnitud;

    @ManyToOne
    @JoinColumn(name = "clasificacion", referencedColumnName = "nombre")
    private ClasificacionSismo clasificacion;

    @ManyToOne
    @JoinColumn(name = "alcance_sismo", referencedColumnName = "nombre")
    private AlcanceSismo alcanceSismo;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "estado_nombre", referencedColumnName = "nombre"),
            @JoinColumn(name = "estado_ambito", referencedColumnName = "ambito")
    })
    private Estado estadoActual;

    @ManyToOne
    @JoinColumn(name = "analista_supervisor_legajo", referencedColumnName = "id")
    private Empleado analistaSupervisor;

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "origen_generacion", referencedColumnName = "origenGeneracion"),
            @JoinColumn(name = "fecha_hora_ocurrencia", referencedColumnName = "fechaHoraOcurrencia")
    })
    private List<CambioEstado> cambiosEstado;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "origen_generacion", referencedColumnName = "origenGeneracion"),
            @JoinColumn(name = "fecha_hora_ocurrencia", referencedColumnName = "fechaHoraOcurrencia")
    })
    private List<SerieTemporal> serieTemporal;

    public EventoSismico() {}

    public EventoSismico(LocalDateTime fechaHoraFin, LocalDateTime fechaHoraOcurrencia, String latitudEpicentro, String latitudHipocentro, String longitudEpicentro, String longitudHipocentro, Float valorMagnitud, ClasificacionSismo clasificacion, MagnitudRichter magnitud, OrigenDeGeneracion origenGeneracion, AlcanceSismo alcanceSismo, Estado estadoActual, Empleado analistaSupervisor, List<CambioEstado> cambiosEstado, List<SerieTemporal> serieTemporal) {
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
        this.latitudEpicentro = latitudEpicentro;
        this.latitudHipocentro = latitudHipocentro;
        this.longitudEpicentro = longitudEpicentro;
        this.longitudHipocentro = longitudHipocentro;
        this.valorMagnitud = valorMagnitud;
        this.clasificacion = clasificacion;
        this.magnitud = magnitud;
        this.origenGeneracion = origenGeneracion;
        this.alcanceSismo = alcanceSismo;
        this.estadoActual = estadoActual;
        this.analistaSupervisor = analistaSupervisor;
        this.cambiosEstado = cambiosEstado;
        this.serieTemporal = serieTemporal;
    }

    public LocalDateTime getFechaHoraOcurrencia() {
        return fechaHoraOcurrencia;
    }

    public void setFechaHoraOcurrencia(LocalDateTime fechaHoraOcurrencia) {
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
    }

    public OrigenDeGeneracion getOrigenGeneracion() {
        return origenGeneracion;
    }

    public void setOrigenGeneracion(OrigenDeGeneracion origenGeneracion) {
        this.origenGeneracion = origenGeneracion;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getLatitudEpicentro() {
        return latitudEpicentro;
    }

    public void setLatitudEpicentro(String latitudEpicentro) {
        this.latitudEpicentro = latitudEpicentro;
    }

    public String getLatitudHipocentro() {
        return latitudHipocentro;
    }

    public void setLatitudHipocentro(String latitudHipocentro) {
        this.latitudHipocentro = latitudHipocentro;
    }

    public String getLongitudEpicentro() {
        return longitudEpicentro;
    }

    public void setLongitudEpicentro(String longitudEpicentro) {
        this.longitudEpicentro = longitudEpicentro;
    }

    public String getLongitudHipocentro() {
        return longitudHipocentro;
    }

    public void setLongitudHipocentro(String longitudHipocentro) {
        this.longitudHipocentro = longitudHipocentro;
    }

    public Float getValorMagnitud() {
        return valorMagnitud;
    }

    public void setValorMagnitud(Float valorMagnitud) {
        this.valorMagnitud = valorMagnitud;
    }

    public MagnitudRichter getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(MagnitudRichter magnitud) {
        this.magnitud = magnitud;
    }

    public ClasificacionSismo getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ClasificacionSismo clasificacion) {
        this.clasificacion = clasificacion;
    }

    public AlcanceSismo getAlcanceSismo() {
        return alcanceSismo;
    }

    public void setAlcanceSismo(AlcanceSismo alcanceSismo) {
        this.alcanceSismo = alcanceSismo;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Empleado getAnalistaSupervisor() {
        return analistaSupervisor;
    }

    public void setAnalistaSupervisor(Empleado analistaSupervisor) {
        this.analistaSupervisor = analistaSupervisor;
    }

    public List<CambioEstado> getCambiosEstado() {
        return cambiosEstado;
    }

    public void setCambiosEstado(List<CambioEstado> cambiosEstado) {
        this.cambiosEstado = cambiosEstado;
    }

    public List<SerieTemporal> getSerieTemporal() {
        return serieTemporal;
    }

    public void setSerieTemporal(List<SerieTemporal> serieTemporal) {
        this.serieTemporal = serieTemporal;
    }

    public Boolean estaPendienteRevision() {
        if (estadoActual.getNombre().equals("Pendiente revision") && estadoActual.getAmbito().equals("Evento sismico")) {
            return true;
        }
        return false;
    }
}
