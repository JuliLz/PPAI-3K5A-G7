package com.grupo7.dsi.tpai.boundaries;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EventoSismicoDTO {
    private final StringProperty fechaHora;
    private final String origenGeneracion;
    private final StringProperty magnitud;
    private final StringProperty lugarOrigen;
    private final BooleanProperty seleccionado = new SimpleBooleanProperty(false);

    public EventoSismicoDTO(String fechaHoraOcurrencia, String origenGeneracion, String magnitud, String lugarOrigen) {
        this.fechaHora = new SimpleStringProperty(fechaHoraOcurrencia);   // cambio acá
        this.origenGeneracion = origenGeneracion;
        this.magnitud = new SimpleStringProperty(magnitud);
        this.lugarOrigen = new SimpleStringProperty(lugarOrigen);
    }

    public StringProperty fechaHoraProperty() {
        return fechaHora;
    }

    public String getOrigenGeneracion() {
        return origenGeneracion;
    }

    public StringProperty magnitudProperty() {
        return magnitud;
    }

    public StringProperty lugarOrigenProperty() {
        return lugarOrigen;
    }

    public BooleanProperty seleccionadoProperty() {
        return seleccionado;
    }

    public boolean isSeleccionado() {
        return seleccionado.get();
    }

    public String getFechaHora() {
        return fechaHora.get();
    }

    public String getMagnitud() {
        return magnitud.get();
    }

    public String getLugarOrigen() {
        return lugarOrigen.get();
    }
}