package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class EstacionSismologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoEstacion;
    private String documentoCertificacionAdq;
    private LocalDate fechaSolicitudCertificacion;
    private String latitud;
    private String longitud;
    private String nombre;
    private Integer nroCertificacionAdquisicion;

    public EstacionSismologica() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EstacionSismologica that = (EstacionSismologica) o;
        return Objects.equals(codigoEstacion, that.codigoEstacion) && Objects.equals(documentoCertificacionAdq, that.documentoCertificacionAdq) && Objects.equals(fechaSolicitudCertificacion, that.fechaSolicitudCertificacion) && Objects.equals(latitud, that.latitud) && Objects.equals(longitud, that.longitud) && Objects.equals(nombre, that.nombre) && Objects.equals(nroCertificacionAdquisicion, that.nroCertificacionAdquisicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoEstacion, documentoCertificacionAdq, fechaSolicitudCertificacion, latitud, longitud, nombre, nroCertificacionAdquisicion);
    }

    public EstacionSismologica(Integer codigoEstacion, String documentoCertificacionAdq, LocalDate fechaSolicitudCertificacion, String latitud, String longitud, String nombre, Integer nroCertificacionAdquisicion) {
        this.codigoEstacion = codigoEstacion;
        this.documentoCertificacionAdq = documentoCertificacionAdq;
        this.fechaSolicitudCertificacion = fechaSolicitudCertificacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion;
    }

    public Integer getCodigoEstacion() {
        return codigoEstacion;
    }

    public void setCodigoEstacion(Integer codigoEstacion) {
        this.codigoEstacion = codigoEstacion;
    }

    public String getDocumentoCertificacionAdq() {
        return documentoCertificacionAdq;
    }

    public void setDocumentoCertificacionAdq(String documentoCertificacionAdq) {
        this.documentoCertificacionAdq = documentoCertificacionAdq;
    }

    public LocalDate getFechaSolicitudCertificacion() {
        return fechaSolicitudCertificacion;
    }

    public void setFechaSolicitudCertificacion(LocalDate fechaSolicitudCertificacion) {
        this.fechaSolicitudCertificacion = fechaSolicitudCertificacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNroCertificacionAdquisicion() {
        return nroCertificacionAdquisicion;
    }

    public void setNroCertificacionAdquisicion(Integer nroCertificacionAdquisicion) {
        this.nroCertificacionAdquisicion = nroCertificacionAdquisicion;
    }
}
