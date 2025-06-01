package com.grupo7.dsi.tpai.models;

public class Sesion {
    private Usuario usuario;

    public Sesion() {}

    public Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
