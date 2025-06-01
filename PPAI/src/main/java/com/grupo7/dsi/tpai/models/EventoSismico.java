package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "origen_generacion", referencedColumnName = "origenGeneracion"),
            @JoinColumn(name = "fecha_hora_ocurrencia", referencedColumnName = "fechaHoraOcurrencia")
    })
    private List<SerieTemporal> seriesTemporal;

    public EventoSismico() {}

    public EventoSismico(LocalDateTime fechaHoraFin, LocalDateTime fechaHoraOcurrencia, String latitudEpicentro, String latitudHipocentro, String longitudEpicentro, String longitudHipocentro, Float valorMagnitud, ClasificacionSismo clasificacion, MagnitudRichter magnitud, OrigenDeGeneracion origenGeneracion, AlcanceSismo alcanceSismo, Estado estadoActual, Empleado analistaSupervisor, List<CambioEstado> cambiosEstado, List<SerieTemporal> seriesTemporal) {
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
        this.seriesTemporal = seriesTemporal;
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

    public List<SerieTemporal> getSeriesTemporal() {
        return seriesTemporal;
    }

    public void setSeriesTemporal(List<SerieTemporal> serieTemporal) {
        this.seriesTemporal = serieTemporal;
    }

    public Boolean estaPendienteRevision() {
        if (estadoActual.esAmbito("Evento sismico") && estadoActual.esNombre("Pendiente revision")) {
            return true;
        }
        return false;
    }

    public void bloquearEnRevision(Estado estadoBloqueado) {
        // Validar que el estadoBloqueado no sea null
        if (estadoBloqueado == null) {
            throw new IllegalArgumentException("El estadoBloqueado no puede ser null, revise si hay problemas con la base de datos");
        }

        // Setear la fechaHoraFin del cambio de estado actual
        for (CambioEstado cambioEstado : cambiosEstado) {
            if (cambioEstado.esEstadoActual()){
                cambioEstado.setFechaHoraFin(LocalDateTime.now());
                break;
            }
        }

        // Crear nuevo cambio de estado (Patron creador)
        CambioEstado cambioEstadoBloqueadoEnRevision = new CambioEstado(estadoBloqueado);
        this.cambiosEstado.add(cambioEstadoBloqueadoEnRevision);

        // Setear el estado actual del evento sismico
        this.setEstadoActual(estadoBloqueado);
    }

    // Devuelve una lista de Strings con los datos del Alcance, Clasificación y Origen del evento sísmico seleccionado.
    public List<String> buscarDatosEventoSismicoSeleccionado() {

        List<String> datos = new ArrayList<>();

        datos.add("Alcance: " + alcanceSismo.getNombre() + " - " + alcanceSismo.getDescripcion());

        datos.add("Clasificación: " + clasificacion.getNombre() + " (" +
                clasificacion.getKmProfundidadDesde() + "km - " +
                clasificacion.getKmProfundidadHasta() + "km)");

        datos.add("Origen: " + origenGeneracion.getNombre() + " - " + origenGeneracion.getDescripcion());

        return datos;
    }

    public void rechazarEventoSismico(Estado estadoRechazado, Empleado responsableInspeccion) {
        // Validar que el estadoRechazado no sea null
        if (estadoRechazado == null) {
            throw new IllegalArgumentException("El estadoRechazado no puede ser null, revise la base de datos");
        }

        // Setear fin del estado actual
        for (CambioEstado cambioEstado : cambiosEstado) {
            if (cambioEstado.esEstadoActual()){
                cambioEstado.setFechaHoraFin(LocalDateTime.now());
                break;
            }
        }

        // Crear nuevo cambio de estado
        CambioEstado cambioEstadoRechazado = new CambioEstado(estadoRechazado);
        cambioEstadoRechazado.setResponsableInspeccion(responsableInspeccion);
        this.cambiosEstado.add(cambioEstadoRechazado);
        this.estadoActual = estadoRechazado;
    }
}
