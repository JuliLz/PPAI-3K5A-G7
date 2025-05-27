package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.models.EventoSismico;
import com.grupo7.dsi.tpai.service.*;
import com.grupo7.dsi.tpai.service.repository.EventoSismicoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorRevisionManual {

    private final EventoSismicoService eventoSismicoService;
    private EventoSismico eventoSismicoSeleccionado;
    private List<EventoSismico> eventosSismicosBDD;

    @Autowired
    public ControladorRevisionManual(EventoSismicoService eventoSismicoService) {
        this.eventoSismicoService = eventoSismicoService;
    }

    @PostConstruct
    public void init() {
        // Inicialización de la lista de eventos sismicos desde la base de datos
        this.eventosSismicosBDD = eventoSismicoService.findAll();
    }


    public List<EventoSismico> registrarResultadoRevisionManual(){
        List<EventoSismico> eventosSismicosPendientesRevision = buscarEventosSismicosPendientesRevision();
        eventosSismicosPendientesRevision = filtrarPorFechayHoraDeOcurrencia(eventosSismicosPendientesRevision);
        if (eventosSismicosPendientesRevision.isEmpty()) {
            return null;
        }
        else {
            return eventosSismicosPendientesRevision;
        }
    }

    public List<EventoSismico> buscarEventosSismicosPendientesRevision() {
        List<EventoSismico> eventosSismicosPendientesRevision = new ArrayList<>();
        for (EventoSismico eventoBDD : eventosSismicosBDD) {
            if (eventoBDD.estaPendienteRevision()) {
                eventosSismicosPendientesRevision.add(eventoBDD);
            }
        }
        return eventosSismicosPendientesRevision;
    }

    public List<EventoSismico> filtrarPorFechayHoraDeOcurrencia(List<EventoSismico> eventosSismicos) {
        List<EventoSismico> eventosFiltrados = new ArrayList<>();
        for (EventoSismico evento : eventosSismicos) {
            if (evento.getFechaHoraFin().isAfter(eventoSismicoSeleccionado.getFechaHoraFin())) {
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }

}
