package com.grupo7.dsi.tpai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class ReclamoGarantia {

    @Id
    private Integer nroReclamo;

    private String comentario;
    private LocalDate fechaReclamo;
    private LocalDate fechaRespuesta;
    private String respuestaFabricante;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "sismografo_id")
    private Sismografo sismografo;

    public ReclamoGarantia() {
    }
}
