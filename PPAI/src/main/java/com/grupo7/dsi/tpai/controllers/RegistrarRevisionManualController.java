package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.boundaries.PantallaRegistrarRevisionManual;
import com.grupo7.dsi.tpai.models.Estado;
import com.grupo7.dsi.tpai.models.EventoSismico;
import com.grupo7.dsi.tpai.service.EstadoService;
import com.grupo7.dsi.tpai.service.EventoSismicoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class RegistrarRevisionManualController {

    @Autowired
    private EventoSismicoService eventoSismicoService;
    private List<EventoSismico> eventosBDD;
    @Autowired
    private EstadoService estadoService;
    private List<Estado> estadosBDD;

    @Autowired @Lazy
    private PantallaRegistrarRevisionManual pantalla;

    private EventoSismico eventoSismicoSeleccionado;

    @PostConstruct
    private void init() {
        this.eventosBDD = eventoSismicoService.findAll();
        this.estadosBDD = estadoService.findAll();
    }

    public void registrarResultadoDeRevisionManual() {
        List<String> raws = buscarEventosSismicosPendientesDeRevision();
        pantalla.mostrarEventosSismicosPendientesDeRevision(raws);
    }

    public List<String> buscarEventosSismicosPendientesDeRevision() {
        List<EventoSismico> eventoSismicosPendientes = new ArrayList<>();
        for (EventoSismico evento : eventosBDD) {
            if (evento.estaPendienteRevision()) {
                eventoSismicosPendientes.add(evento);
            }
        }
        // ordenar por fecha y hora de ocurrencia
        eventoSismicosPendientes = filtrarPorFechayHoraDeOcurrencia(eventoSismicosPendientes);

        // convertir a String con 4 campos separados por coma
        List<String> raws = new ArrayList<>();
        for (EventoSismico evento : eventoSismicosPendientes) {
            // antes ponías clasificación en p[3], ahora repetimos origen:
            String raw = String.join(",",
                    evento.getFechaHoraOcurrencia().toString(),
                    evento.getOrigenGeneracion().getNombre(),
                    String.valueOf(evento.getMagnitud().getNumero()),
                    evento.getOrigenGeneracion().getNombre()    // <-- aquí
            );
            raws.add(raw);
        }
        return raws;
    }

    private List<EventoSismico> filtrarPorFechayHoraDeOcurrencia(List<EventoSismico> eventos) {
        return eventos.stream()
                .sorted(Comparator.comparing(EventoSismico::getFechaHoraOcurrencia))
                .collect(Collectors.toList());
    }

    public void tomarSeleccionEventoSismico(String fechaHoraStr, String origen) {
        LocalDateTime fecha = LocalDateTime.parse(fechaHoraStr);
        // busco el evento sísmico seleccionado
        for (EventoSismico evento : eventosBDD) {
            if (evento.getFechaHoraOcurrencia().equals(fecha)
                    && evento.getOrigenGeneracion().getNombre().equals(origen)) {
                this.eventoSismicoSeleccionado = evento;
            }
        }

        // Cambio de estado del evento sísmico
        cambioEstadoEventoSismico();

        // Buscar los datos del evento sismico
        buscarDatosEventoSismicoSeleccionado();
    }

    private void cambioEstadoEventoSismico() {
        Estado estadoBloqueado = estadosBDD.stream()
                .filter(estado -> estado.sosBloqueadoEnRevision())
                .findFirst()
                .orElse(null);

        // Cambiar el estado del evento sísmico a "Bloqueado"
        this.eventoSismicoSeleccionado.cambioEstadoBloqueadoEnRevision(estadoBloqueado);

    }

    private void buscarDatosEventoSismicoSeleccionado() {
        if (eventoSismicoSeleccionado == null) {
            pantalla.mostrarDatosEventoSismicoSeleccionado(Collections.emptyList()); // no hay evento seleccionado
        }

        List<String> datos = new ArrayList<>();
        datos.add("fechaHoraOcurrencia:" + eventoSismicoSeleccionado.getFechaHoraOcurrencia());
        datos.add("origenGeneracion:"     + eventoSismicoSeleccionado.getOrigenGeneracion().getNombre());
        datos.add("fechaHoraFin:"         + Optional.ofNullable(eventoSismicoSeleccionado.getFechaHoraFin()).orElse(null));
        datos.add("latitudEpicentro:"     + eventoSismicoSeleccionado.getLatitudEpicentro());
        datos.add("longitudEpicentro:"    + eventoSismicoSeleccionado.getLongitudEpicentro());
        datos.add("latitudHipocentro:"    + eventoSismicoSeleccionado.getLatitudHipocentro());
        datos.add("longitudHipocentro:"   + eventoSismicoSeleccionado.getLongitudHipocentro());
        datos.add("valorMagnitud:"        + eventoSismicoSeleccionado.getValorMagnitud());
        datos.add("magnitudRichter:"      + eventoSismicoSeleccionado.getMagnitud().getNumero());
        datos.add("clasificacionSismo:"   + eventoSismicoSeleccionado.getClasificacion().getNombre());
        datos.add("alcanceSismo:"         + eventoSismicoSeleccionado.getAlcanceSismo().getNombre());
        datos.add("estadoActual:"         + eventoSismicoSeleccionado.getEstadoActual().getNombre());
        if (eventoSismicoSeleccionado.getAnalistaSupervisor() != null) {
            datos.add("analistaSupervisor:"
                    + eventoSismicoSeleccionado.getAnalistaSupervisor().getNombre()
                    + " (Legajo " + eventoSismicoSeleccionado.getAnalistaSupervisor().getId() + ")");
        } else {
            datos.add("analistaSupervisor:N/A");
        }

        pantalla.mostrarDatosEventoSismicoSeleccionado(datos);
    }
}