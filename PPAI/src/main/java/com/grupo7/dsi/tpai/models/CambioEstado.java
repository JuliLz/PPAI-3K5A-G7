package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@IdClass(CambioEstadoId.class)
public class CambioEstado {

    @Id
    private LocalDateTime fechaHoraInicio;

    @Id
    @Column(name = "estado_nombre")
    private String estadoNombre;

    @Id
    @Column(name = "estado_ambito")
    private String estadoAmbito;

    private LocalDateTime fechaHoraFin;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "estado_nombre", referencedColumnName = "nombre", insertable = false, updatable = false),
            @JoinColumn(name = "estado_ambito", referencedColumnName = "ambito", insertable = false, updatable = false)
    })
    private Estado estado;

    @ManyToOne
    private Empleado responsableInspeccion;

    @ManyToMany
    private List<MotivoFueraServicio> motivoFueraServicio;

    @ManyToOne
    @JoinColumn(name = "sismografo_id")
    private Sismografo sismografo; //Sismografos que tienen este cambio de estado

    public CambioEstado() {}

    public CambioEstado(Estado estadoParametro){
        this.estadoNombre = estadoParametro.getNombre();
        this.estadoAmbito = estadoParametro.getAmbito();
        this.estado = estadoParametro;
        this.fechaHoraInicio = LocalDateTime.now();
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getEstadoAmbito() {
        return estadoAmbito;
    }

    public void setEstadoAmbito(String estadoAmbito) {
        this.estadoAmbito = estadoAmbito;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Empleado getResponsableInspeccion() {
        return responsableInspeccion;
    }

    public void setResponsableInspeccion(Empleado responsableInspeccion) {
        this.responsableInspeccion = responsableInspeccion;
    }

    public List<MotivoFueraServicio> getMotivoFueraServicio() {
        return motivoFueraServicio;
    }

    public void setMotivoFueraServicio(List<MotivoFueraServicio> motivoFueraServicio) {
        this.motivoFueraServicio = motivoFueraServicio;
    }

    public Boolean esEstadoActual(){
        if (this.fechaHoraFin == null) {
            return true;
        }
        return false;
    }

    // getters, setters, constructor vacío
}