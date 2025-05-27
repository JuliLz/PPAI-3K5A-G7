package com.grupo7.dsi.tpai.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PlanConstruccionES {

    @Id
    private Integer codigoPlanConstruccion;

    private LocalDate fechaFinalizacion;
    private LocalDate fechaPrevistaInicio;
    private LocalDate fechaProbableInicioPruebas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "estacion_id")
    private EstacionSismologica estacionSismologica;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "empleado_id")
    private Empleado encargadoInstalacion;

    @OneToOne
    @JoinColumn(name = "sismografo_id", unique = true) // FK en la tabla PlanConstruccionES
    private Sismografo sismografoAsignado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_construccion_id") // Crea la FK en TrabajoARealizar
    private List<TrabajoARealizar> trabajosARealizar;

    public PlanConstruccionES() {}
}
