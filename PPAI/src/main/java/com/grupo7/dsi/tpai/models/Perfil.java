package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Perfil {

    @Id
    private String nombre;
    private String descripcion;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "perfiles_permisos",
            joinColumns = @jakarta.persistence.JoinColumn(name = "perfil_nombre"),
            inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "permiso_nombre")
    )
    private List<Permiso> permisos;

    public Perfil() {}

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public Perfil(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Perfil(String nombre, String descripcion, List<Permiso> permisos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.permisos = permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
}
