package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class MuestraSismica {

    @Id
    private Integer id;

    private LocalDateTime fechaHoraMuestra;

    @OneToMany
    @JoinColumn(name = "muestra_sismica_id") // la FK se guarda en DetalleMuestraSismica
    private List<DetalleMuestraSismica> detallesMuestraSismica;

    public MuestraSismica(LocalDateTime fechaHoraMuestra, List<DetalleMuestraSismica> detalleMuestraSismica) {
        this.fechaHoraMuestra = fechaHoraMuestra;
        this.detallesMuestraSismica = detalleMuestraSismica;
    }

    public MuestraSismica() {
    }

    public LocalDateTime getFechaHoraMuestra() {
        return fechaHoraMuestra;
    }

    public void setFechaHoraMuestra(LocalDateTime fechaHoraMuestra) {
        this.fechaHoraMuestra = fechaHoraMuestra;
    }

    public List<DetalleMuestraSismica> getDetallesMuestraSismica() {
        return detallesMuestraSismica;
    }

    public void setDetallesMuestraSismica(List<DetalleMuestraSismica> detallesMuestraSismica) {
        this.detallesMuestraSismica = detallesMuestraSismica;
    }

    // crear detalle muestra
    public void agregarDetalleMuestraSismica(DetalleMuestraSismica detalle) {
        if (detalle != null) {
            this.detallesMuestraSismica.add(detalle);
        }
    }
}
