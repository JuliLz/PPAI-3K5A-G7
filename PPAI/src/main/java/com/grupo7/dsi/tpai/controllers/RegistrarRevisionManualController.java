package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.boundaries.PantallaRegistrarRevisionManual;
import com.grupo7.dsi.tpai.models.EventoSismico;
import com.grupo7.dsi.tpai.service.EventoSismicoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegistrarRevisionManualController {

    private final EventoSismicoService eventoSismicoService;
    private List<EventoSismico> eventosSismicosBDD;
    private EventoSismico eventosSismicoSeleccionado;

    @Autowired
    public RegistrarRevisionManualController(EventoSismicoService eventoSismicoService) {
        this.eventoSismicoService = eventoSismicoService;
    }

    @PostConstruct
    private void init() {
        this.eventosSismicosBDD = eventoSismicoService.findAll();
    }

    /**
     * Devuelve una lista de cadenas "fecha,magnitud,lugar" de
     * los eventos pendientes de revisión, ordenados por fecha.
     */
    public List<String> buscarEventosSismicosPendientesRevision() {
        return eventosSismicosBDD.stream()
                .filter(EventoSismico::estaPendienteRevision)
                .sorted(Comparator.comparing(EventoSismico::getFechaHoraOcurrencia))
                .map(e -> e.getFechaHoraOcurrencia() + "," // clave 1
                        + e.getOrigenGeneracion().getNombre() + "," // clave 2
                        + e.getMagnitud().getNumero() + ","
                        + e.getOrigenGeneracion().getNombre()) // también usado como columna
                .collect(Collectors.toList());
    }

    public void tomarSeleccionEventoSismico(String fechaHoraStr, String nombreOrigen){
        System.out.println("Tomando selección de evento sismico: " + fechaHoraStr + ", " + nombreOrigen);
        LocalDateTime fechaHora;
        try {
            fechaHora = LocalDateTime.parse(fechaHoraStr); //
        } catch (Exception e) {
            System.out.println("Error al convertir fechaHoraStr: " + e.getMessage());
            return;
        }

        for (EventoSismico evento : eventosSismicosBDD) {
            if (evento.getFechaHoraOcurrencia().equals(fechaHora)
                    && evento.getOrigenGeneracion().getNombre().equals(nombreOrigen)) {
                this.eventosSismicoSeleccionado = evento;
                System.out.println("Evento seleccionado: " + evento);
                break;
            }
        }
    }
}