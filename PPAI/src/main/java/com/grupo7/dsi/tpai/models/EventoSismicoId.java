package com.grupo7.dsi.tpai.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class EventoSismicoId implements Serializable {

    private String origenGeneracion;  // porque OrigenDeGeneracion usa 'denominacion' como PK
    private LocalDateTime fechaHoraOcurrencia;

    public EventoSismicoId() {
    }

    public EventoSismicoId(String origenGeneracion, LocalDateTime fechaHoraOcurrencia) {
        this.origenGeneracion = origenGeneracion;
        this.fechaHoraOcurrencia = fechaHoraOcurrencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventoSismicoId that)) return false;
        return Objects.equals(origenGeneracion, that.origenGeneracion)
                && Objects.equals(fechaHoraOcurrencia, that.fechaHoraOcurrencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origenGeneracion, fechaHoraOcurrencia);
    }
}
